package com.gestiondestock.DTO;
import com.gestiondestock.Model.AbstractEntity;
import com.gestiondestock.Model.LigneCommandeFournisseur;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFournisseurDTO {
    private Integer id;
    private ArticleDTO article;
    private CommandeFournisseurDTO commandeFournisseur;


    private BigDecimal quantite;

    private BigDecimal prixUnitaire;
    public static LigneCommandeFournisseurDTO fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
        if (ligneCommandeFournisseur == null) {
            return null;
        }
        return LigneCommandeFournisseurDTO.builder()
                .id(ligneCommandeFournisseur.getId())
                .article(ArticleDTO.fromEntity(ligneCommandeFournisseur.getArticle()))
                .quantite(ligneCommandeFournisseur.getQuantite())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDTO dto) {
        if (dto == null) {
            return null;
        }

        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(dto.getId());
        ligneCommandeFournisseur.setArticle(ArticleDTO.toEntity(dto.getArticle()));
        ligneCommandeFournisseur.setPrixUnitaire(dto.getPrixUnitaire());
        ligneCommandeFournisseur.setQuantite(dto.getQuantite());
        return ligneCommandeFournisseur;
    }
}
