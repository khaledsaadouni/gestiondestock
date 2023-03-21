package com.gestiondestock.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Roles extends AbstractEntity {
    public String roleName;
    @ManyToOne
    @JoinColumn(name="idUtilisteur")
    private Utilisateur utilisateur;
}
