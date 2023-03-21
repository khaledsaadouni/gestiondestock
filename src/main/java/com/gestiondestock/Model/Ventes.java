package com.gestiondestock.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Ventes  extends AbstractEntity{
    private String code;
    private Instant dateVente;
    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVentes;
    public String commentaire;
}
