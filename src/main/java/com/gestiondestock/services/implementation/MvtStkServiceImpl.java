package com.gestiondestock.services.implementation;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.gestiondestock.DTO.MvtStockDTO;
import com.gestiondestock.Model.TypeMvtStk;
import com.gestiondestock.repository.MvtStockkRepository;
import com.gestiondestock.services.ArticleService;
import com.gestiondestock.services.MvtStkService;
import com.gestiondestock.validator.MvtStkValidator;
import com.gestiondestock.exception.ErrorCodes;
import com.gestiondestock.exception.InvalidEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MvtStkServiceImpl implements MvtStkService {

  private MvtStockkRepository repository;
  private ArticleService articleService;

  @Autowired
  public MvtStkServiceImpl(MvtStockkRepository repository, ArticleService articleService) {
    this.repository = repository;
    this.articleService = articleService;
  }

  @Override
  public BigDecimal stockReelArticle(Integer idArticle) {
    if (idArticle == null) {
      log.warn("ID article is NULL");
      return BigDecimal.valueOf(-1);
    }
    articleService.findById(idArticle);
    return repository.stockReelArticle(idArticle);
  }

  @Override
  public List<MvtStockDTO> mvtStkArticle(Integer idArticle) {
    return repository.findAllByArticleId(idArticle).stream()
        .map(MvtStockDTO::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public MvtStockDTO entreeStock(MvtStockDTO dto) {
    return entreePositive(dto, TypeMvtStk.ENTREE);
  }

  @Override
  public MvtStockDTO sortieStock(MvtStockDTO dto) {
    return sortieNegative(dto, TypeMvtStk.SORTIE);
  }

  @Override
  public MvtStockDTO correctionStockPos(MvtStockDTO dto) {
    return entreePositive(dto, TypeMvtStk.CORRECTION_POS);
  }

  @Override
  public MvtStockDTO correctionStockNeg(MvtStockDTO dto) {
    return sortieNegative(dto, TypeMvtStk.CORRECTION_NEG);
  }

  private MvtStockDTO entreePositive(MvtStockDTO dto, TypeMvtStk typeMvtStk) {
    List<String> errors = MvtStkValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Article is not valid {}", dto);
      throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
    }
    dto.setQuantite(
        BigDecimal.valueOf(
            Math.abs(dto.getQuantite().doubleValue())
        )
    );
    dto.setTypeMvt(typeMvtStk);
    return MvtStockDTO.fromEntity(
        repository.save(MvtStockDTO.toEntity(dto))
    );
  }

  private MvtStockDTO sortieNegative(MvtStockDTO dto, TypeMvtStk typeMvtStk) {
    List<String> errors = MvtStkValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Article is not valid {}", dto);
      throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
    }
    dto.setQuantite(
        BigDecimal.valueOf(
            Math.abs(dto.getQuantite().doubleValue()) * -1
        )
    );
    dto.setTypeMvt(typeMvtStk);
    return MvtStockDTO.fromEntity(
        repository.save(MvtStockDTO.toEntity(dto))
    );
  }
}
