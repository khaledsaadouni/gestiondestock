package com.gestiondestock.DTO;
import com.gestiondestock.Model.AbstractEntity;
import com.gestiondestock.Model.Roles;
import com.gestiondestock.Model.Utilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
public class RolesDTO {
    private Integer id;
    public String nom;

    public String roleName;
    private UtilisateurDTO utilisateur;
    public static RolesDTO fromEntity(Roles roles) {
        if (roles == null) {
            return null;
        }
        return RolesDTO.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDTO dto) {
        if (dto == null) {
            return null;
        }
        Roles roles = new Roles();
        roles.setId(dto.getId());
        roles.setRoleName(dto.getRoleName());
        roles.setUtilisateur(UtilisateurDTO.toEntity(dto.getUtilisateur()));
        return roles;
    }
}
