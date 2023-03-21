package com.gestiondestock.DTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestiondestock.Model.AbstractEntity;
import com.gestiondestock.Model.Adresse;
import com.gestiondestock.Model.Fournisseur;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@Builder
public class FournisseurDTO {
    private Integer id;
    private String nom;
    private String prenom;
    private AdresseDTO adresse;
    private String photo;
    private String mail;
    private String numTel;
    @JsonIgnore
    private List<CommandeFournisseurDTO> commandeFournisseurs;
    public static FournisseurDTO fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        return FournisseurDTO.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .adresse(AdresseDTO.fromEntity(fournisseur.getAdresse()))
                .photo(fournisseur.getPhoto())
                .mail(fournisseur.getMail())
                .numTel(fournisseur.getNumTel())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDTO dto) {
        if (dto == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(dto.getId());
        fournisseur.setNom(dto.getNom());
        fournisseur.setPrenom(dto.getPrenom());
        fournisseur.setAdresse(AdresseDTO.toEntity(dto.getAdresse()));
        fournisseur.setPhoto(dto.getPhoto());
        fournisseur.setMail(dto.getMail());
        fournisseur.setNumTel(dto.getNumTel());
        return fournisseur;
    }
}
