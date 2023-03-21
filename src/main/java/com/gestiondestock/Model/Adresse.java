package com.gestiondestock.Model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adresse {
    private String adresse1;
    private String adresse2;
    private String ville;
    private String codePostale;
    private String pays;

}
