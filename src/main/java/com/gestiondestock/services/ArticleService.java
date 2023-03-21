package com.gestiondestock.services;

import com.gestiondestock.DTO.ArticleDTO;

import java.util.List;

public interface ArticleService {
    ArticleDTO save(ArticleDTO dto);
    ArticleDTO findById(Integer id);
    ArticleDTO findByCodeArticle(String codeArticle);
    List<ArticleDTO> findAll();
    void delete(Integer id);
}
