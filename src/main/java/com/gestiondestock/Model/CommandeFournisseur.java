package com.gestiondestock.Model;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Entity
@Table
public class CommandeFournisseur extends AbstractEntity {
    private String code;
    private Instant dateCommande;
    private EtatCommande etatCommande;
    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    private  Fournisseur fournisseur;
    @OneToMany(mappedBy = "commandeFournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

}
