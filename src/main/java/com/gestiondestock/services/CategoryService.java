package com.gestiondestock.services;

import com.gestiondestock.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {

  CategoryDTO save(CategoryDTO dto);

  CategoryDTO findById(Integer id);

  CategoryDTO findByCode(String code);

  List<CategoryDTO> findAll();

  void delete(Integer id);

}
