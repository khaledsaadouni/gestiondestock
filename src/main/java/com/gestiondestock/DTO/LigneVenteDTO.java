package com.gestiondestock.DTO;
import com.gestiondestock.Model.AbstractEntity;
import com.gestiondestock.Model.LigneVente;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDTO {
    private Integer id;
    private VentesDTO vente;
    private ArticleDTO article;
    private BigDecimal quantite;

    private BigDecimal prixUnitaire;
    public static LigneVenteDTO fromEntity(LigneVente ligneVente) {
        if (ligneVente == null) {
            return null;
        }

        return LigneVenteDTO.builder()
                .id(ligneVente.getId())
                .vente(VentesDTO.fromEntity(ligneVente.getVente()))
                .article(ArticleDTO.fromEntity(ligneVente.getArticle()))
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDTO dto) {
        if (dto == null) {
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(dto.getId());
        ligneVente.setVente(VentesDTO.toEntity(dto.getVente()));
        ligneVente.setArticle(ArticleDTO.toEntity(dto.getArticle()));
        ligneVente.setQuantite(dto.getQuantite());
        ligneVente.setPrixUnitaire(dto.getPrixUnitaire());
        return ligneVente;
    }

}
