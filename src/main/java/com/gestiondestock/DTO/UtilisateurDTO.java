package com.gestiondestock.DTO;
import com.gestiondestock.Model.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UtilisateurDTO {
    private Integer id;
    private String nom;
    private String prenom;
    private String password;
    private String email;
    private String photo;
    private AdresseDTO adresse;
    private Instant datedeNaissance;
    private EntrepriseDTO entreprise;

    private List<RolesDTO> roles;
    public static UtilisateurDTO fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDTO.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .password(utilisateur.getPassword())
                .datedeNaissance(utilisateur.getDatedeNaissance())
                .adresse(AdresseDTO.fromEntity(utilisateur.getAdresse()))
                .photo(utilisateur.getPhoto())
                .entreprise(EntrepriseDTO.fromEntity(utilisateur.getEntreprise()))
                .roles(
                        utilisateur.getRoles() != null ?
                                utilisateur.getRoles().stream()
                                        .map(RolesDTO::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDTO dto) {
        if (dto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(dto.getId());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setPassword(dto.getPassword());
        utilisateur.setDatedeNaissance(dto.getDatedeNaissance());
        utilisateur.setAdresse(AdresseDTO.toEntity(dto.getAdresse()));
        utilisateur.setPhoto(dto.getPhoto());
        utilisateur.setEntreprise(EntrepriseDTO.toEntity(dto.getEntreprise()));

        return utilisateur;
    }
}
