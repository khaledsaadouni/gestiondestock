package com.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.gestiondestock.DTO.ArticleDTO;
import org.springframework.util.StringUtils;

public class ArticleValidator {

  public static List<String> validate(ArticleDTO dto) {
    List<String> errors = new ArrayList<>();

    if (dto == null) {
      errors.add("Veuillez renseigner le code de l'article");
      errors.add("Veuillez renseigner la designation de l'article");
      errors.add("Veuillez renseigner le prix unitaire HT l'article");
      errors.add("Veuillez renseigner le taux TVA de l'article");
      errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
      errors.add("Veuillez selectionner une categorie");
      return errors;
    }

    if (!StringUtils.hasLength(dto.getCodeArticle())) {
      errors.add("Veuillez renseigner le code de l'article");
    }
    if (!StringUtils.hasLength(dto.getDesignation())) {
      errors.add("Veuillez renseigner la designation de l'article");
    }
    if (dto.getPrixUnitaireHT() == null) {
      errors.add("Veuillez renseigner le prix unitaire HT l'article");
    }
    if (dto.getTauxTVA() == null) {
      errors.add("Veuillez renseigner le taux TVA de l'article");
    }
    if (dto.getPrixUnitaireTTC() == null) {
      errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
    }
    if (dto.getCategory() == null || dto.getCategory().getId() == null) {
      errors.add("Veuillez selectionner une categorie");
    }
    return errors;
  }

}
