package com.gestiondestock.DTO;
import com.gestiondestock.Model.AbstractEntity;
import com.gestiondestock.Model.Adresse;
import com.gestiondestock.Model.Article;
import com.gestiondestock.Model.Client;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@Builder
public class ClientDTO {
    private Integer id;
    private String nom;
    private String prenom;
    private AdresseDTO adresse;
    private String photo;
    private String mail;
    private String numTel;
    private List<CommandeClientDTO> commandeClients;
    public static ClientDTO fromEntity(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDTO.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(AdresseDTO.fromEntity(client.getAdresse()))
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .build();
    }

    public static Client toEntity(ClientDTO dto) {
        if (dto == null) {
            return null;
        }
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setAdresse(AdresseDTO.toEntity(dto.getAdresse()));
        client.setPhoto(dto.getPhoto());
        client.setMail(dto.getMail());
        client.setNumTel(dto.getNumTel());
        return client;
    }
}
