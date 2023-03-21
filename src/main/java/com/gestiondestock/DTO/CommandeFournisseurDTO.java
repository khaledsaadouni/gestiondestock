package com.gestiondestock.DTO;
import com.gestiondestock.Model.AbstractEntity;
import com.gestiondestock.Model.CommandeFournisseur;
import com.gestiondestock.Model.EtatCommande;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeFournisseurDTO {
    private Integer id;
    private EtatCommande etatCommande;
    private String code;
    private Instant dateCommande;
    private FournisseurDTO fournisseur;
    private List<LigneCommandeFournisseurDTO> ligneCommandeFournisseurs;
    public static CommandeFournisseurDTO fromEntity(CommandeFournisseur commandeFournisseur) {
        if (commandeFournisseur == null) {
            return null;
        }
        return CommandeFournisseurDTO.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .fournisseur(FournisseurDTO.fromEntity(commandeFournisseur.getFournisseur()))
                .etatCommande(commandeFournisseur.getEtatCommande())
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDTO dto) {
        if (dto == null) {
            return null;
        }
        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(dto.getId());
        commandeFournisseur.setCode(dto.getCode());
        commandeFournisseur.setDateCommande(dto.getDateCommande());
        commandeFournisseur.setFournisseur(FournisseurDTO.toEntity(dto.getFournisseur()));
        commandeFournisseur.setEtatCommande(dto.getEtatCommande());
        return commandeFournisseur;
    }

    public boolean isCommandeLivree() {
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }

}
