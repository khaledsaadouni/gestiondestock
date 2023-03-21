package com.gestiondestock.DTO;

import com.gestiondestock.Model.Article;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
public class ArticleDTO {
    private Integer id;

    private String codeArticle;
    private String designation;
    private BigDecimal prixUnitaireHT;
    private BigDecimal tauxTVA;
    private BigDecimal prixUnitaireTTC;
    private String Photo;
    private CategoryDTO category;

    private Integer idEntreprise;
    public static ArticleDTO fromEntity(Article article) {
        if (article == null) {
            return null;
        }
        return ArticleDTO.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .Photo(article.getPhoto())
                .prixUnitaireHT(article.getPrixUnitaireHT())
                .prixUnitaireTTC(article.getPrixUnitaireTTC())
                .tauxTVA(article.getTauxTVA())
                .idEntreprise(article.getIdEntreprise())
                .category(CategoryDTO.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDTO articleDto) {
        if (articleDto == null) {
            return null;
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPhoto(articleDto.getPhoto());
        article.setPrixUnitaireHT(articleDto.getPrixUnitaireHT());
        article.setPrixUnitaireTTC(articleDto.getPrixUnitaireTTC());
        article.setTauxTVA(articleDto.getTauxTVA());
        article.setIdEntreprise(articleDto.getIdEntreprise());
        article.setCategory(CategoryDTO.toEntity(articleDto.getCategory()));
        return article;
    }


}
