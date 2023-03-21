package com.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.gestiondestock.DTO.CategoryDTO;
import org.springframework.util.StringUtils;

public class CategoryValidator {

  public static List<String> validate(CategoryDTO categoryDto) {
    List<String> errors = new ArrayList<>();

    if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())) {
      errors.add("Veuillez renseigner le code de la categorie");
    }
    return errors;
  }

}
