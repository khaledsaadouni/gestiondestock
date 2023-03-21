package com.gestiondestock.controller;

import java.util.List;

import com.gestiondestock.DTO.ArticleDTO;
import com.gestiondestock.DTO.LigneVenteDTO;
import com.gestiondestock.controller.api.ArticleApi;
import com.gestiondestock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    @Autowired
    public ArticleController(
            ArticleService articleService
    ) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDTO save(ArticleDTO dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDTO findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDTO findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDTO> findAll() {
        return articleService.findAll();
    }

    // @Override
//  public List<LigneVenteDTO> findHistoriqueVentes(Integer idArticle) {
//    return articleService.findHistoriqueVentes(idArticle);
//  }
//
//  @Override
//  public List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle) {
//    return articleService.findHistoriaueCommandeClient(idArticle);
//  }
//
//  @Override
//  public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
//    return articleService.findHistoriqueCommandeFournisseur(idArticle);
//  }
//
//  @Override
//  public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
//    return articleService.findAllArticleByIdCategory(idCategory);
//  }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }
}
