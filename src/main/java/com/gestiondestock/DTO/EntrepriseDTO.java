package com.gestiondestock.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestiondestock.Model.AbstractEntity;
import com.gestiondestock.Model.Adresse;
import com.gestiondestock.Model.Entreprise;
import com.gestiondestock.Model.Utilisateur;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@Builder
public class EntrepriseDTO {
    private Integer id;
    private String nom;
    private String description;
    private AdresseDTO adresse ;
    private String codeFiscal;
    private String email;
    private String numTel;
    private String photo;
    private  String siteWeb;
    @JsonIgnore
    private List<UtilisateurDTO> utilisateurs;
    public static EntrepriseDTO fromEntity(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }
        return EntrepriseDTO.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .adresse(AdresseDTO.fromEntity(entreprise.getAdresse()))
                .codeFiscal(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDTO dto) {
        if (dto == null) {
            return null;
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(dto.getId());
        entreprise.setNom(dto.getNom());
        entreprise.setDescription(dto.getDescription());
        entreprise.setAdresse(AdresseDTO.toEntity(dto.getAdresse()));
        entreprise.setCodeFiscal(dto.getCodeFiscal());
        entreprise.setPhoto(dto.getPhoto());
        entreprise.setEmail(dto.getEmail());
        entreprise.setNumTel(dto.getNumTel());
        entreprise.setSiteWeb(dto.getSiteWeb());

        return entreprise;
    }

}
