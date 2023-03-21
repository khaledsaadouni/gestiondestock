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
public class Fournisseur  extends AbstractEntity{
    private String nom;
    private String prenom;
    @Embedded //c'est un champs composé
    private Adresse adresse;
    private String photo;
    private String mail;
    private String numTel;
    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
}
