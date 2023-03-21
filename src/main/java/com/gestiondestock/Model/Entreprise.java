package com.gestiondestock.Model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Entreprise extends AbstractEntity{
    private String nom;
    private String description;

    private String photo;
    @Embedded
    private Adresse adresse ;
    private String codeFiscal;
    private String email;
    private String numTel;
    private  String siteWeb;
    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;

}
