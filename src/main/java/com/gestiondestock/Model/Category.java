package com.gestiondestock.Model;
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
public class Category extends AbstractEntity {
    private String code;
    private String designation;
    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
