package com.gestiondestock.Model;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Utilisateur extends AbstractEntity {
    private String nom;
    private String prenom;
    private String password;
    private String email;
    private String photo;
    @Embedded
    private  Adresse adresse;
    private Instant datedeNaissance;
    @ManyToOne
    @JoinColumn(name = "identreprise")
    private Entreprise entreprise;
    @OneToMany(mappedBy = "utilisateur")
    private List<Roles> roles;

}
