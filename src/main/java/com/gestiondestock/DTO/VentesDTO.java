package com.gestiondestock.DTO;
import com.gestiondestock.Model.AbstractEntity;
import com.gestiondestock.Model.Ventes;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class VentesDTO  {
    private Integer id;
    private String code;
    private Instant dateVente;
    private List<LigneVenteDTO> ligneVentes;

    public String commentaire;
    public static VentesDTO fromEntity(Ventes vente) {
        if (vente == null) {
            return null;
        }
        return VentesDTO.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .commentaire(vente.getCommentaire())
                .build();
    }

    public static Ventes toEntity(VentesDTO dto) {
        if (dto == null) {
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(dto.getId());
        ventes.setCode(ventes.getCode());
        ventes.setCommentaire(dto.getCommentaire());
        return ventes;
    }
}
