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
public class CommandeClient extends AbstractEntity {
    private String code;
    private Instant dateCommande;
    private EtatCommande etatCommande;
    @ManyToOne
    @JoinColumn(name = "idClient")
    private  Client client;
    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;
}
