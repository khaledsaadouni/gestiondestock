package com.gestiondestock.DTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestiondestock.Model.AbstractEntity;
import com.gestiondestock.Model.LigneCommandeClient;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDTO {
    private Integer id;

    private ArticleDTO article;
    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    @JsonIgnore
    private CommandeClientDTO commandeClient;
    public static LigneCommandeClientDTO fromEntity(LigneCommandeClient ligneCommandeClient) {
        if (ligneCommandeClient == null) {
            return null;
        }
        return LigneCommandeClientDTO.builder()
                .id(ligneCommandeClient.getId())
                .article(ArticleDTO.fromEntity(ligneCommandeClient.getArticle()))
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDTO dto) {
        if (dto == null) {
            return null;
        }

        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(dto.getId());
        ligneCommandeClient.setArticle(ArticleDTO.toEntity(dto.getArticle()));
        ligneCommandeClient.setPrixUnitaire(dto.getPrixUnitaire());
        ligneCommandeClient.setQuantite(dto.getQuantite());
        return ligneCommandeClient;
    }
}
