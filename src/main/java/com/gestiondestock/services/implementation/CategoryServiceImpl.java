package com.gestiondestock.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import com.gestiondestock.DTO.CategoryDTO;
import com.gestiondestock.Model.Article;
import com.gestiondestock.repository.ArticleRepository;
import com.gestiondestock.repository.CategoryRepository;
import com.gestiondestock.services.CategoryService;
import com.gestiondestock.validator.CategoryValidator;
import com.gestiondestock.exception.EntityNotFoundException;
import com.gestiondestock.exception.ErrorCodes;
import com.gestiondestock.exception.InvalidEntityException;
import com.gestiondestock.exception.InvalidOperationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

  private CategoryRepository categoryRepository;
  private ArticleRepository articleRepository;

  @Autowired
  public CategoryServiceImpl(CategoryRepository categoryRepository, ArticleRepository articleRepository) {
    this.categoryRepository = categoryRepository;
    this.articleRepository = articleRepository;
  }

  @Override
  public CategoryDTO save(CategoryDTO dto) {
    List<String> errors = CategoryValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Article is not valid {}", dto);
      throw new InvalidEntityException("La category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
    }
    return CategoryDTO.fromEntity(
        categoryRepository.save(CategoryDTO.toEntity(dto))
    );
  }

  @Override
  public CategoryDTO findById(Integer id) {
    if (id == null) {
      log.error("Category ID is null");
      return null;
    }
    return categoryRepository.findById(id)
        .map(CategoryDTO::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune category avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.CATEGORY_NOT_FOUND)
        );
  }

  @Override
  public CategoryDTO findByCode(String code) {
    if (!StringUtils.hasLength(code)) {
      log.error("Category CODE is null");
      return null;
    }
    return categoryRepository.findCategoryByCode(code)
        .map(CategoryDTO::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune category avec le CODE = " + code + " n' ete trouve dans la BDD",
            ErrorCodes.CATEGORY_NOT_FOUND)
        );
  }

  @Override
  public List<CategoryDTO> findAll() {
    return categoryRepository.findAll().stream()
        .map(CategoryDTO::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Category ID is null");
      return;
    }

    List<Article> articles = articleRepository.findAllByCategoryId(id);
    if (!articles.isEmpty()) {
      throw new InvalidOperationException("Impossible de supprimer cette categorie qui est deja utilise",
          ErrorCodes.CATEGORY_ALREADY_IN_USE);
    }
    categoryRepository.deleteById(id);
  }
}
