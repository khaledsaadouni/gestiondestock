package com.gestiondestock.controller;

import java.util.List;

import com.gestiondestock.DTO.CategoryDTO;
import com.gestiondestock.controller.api.CategoryApi;
import com.gestiondestock.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController implements CategoryApi {

  private CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @Override
  public CategoryDTO save(CategoryDTO dto) {
    return categoryService.save(dto);
  }

  @Override
  public CategoryDTO findById(Integer idCategory) {
    return categoryService.findById(idCategory);
  }

  @Override
  public CategoryDTO findByCode(String codeCategory) {
    return categoryService.findByCode(codeCategory);
  }

  @Override
  public List<CategoryDTO> findAll() {
    return categoryService.findAll();
  }

  @Override
  public void delete(Integer id) {
    categoryService.delete(id);
  }
}
