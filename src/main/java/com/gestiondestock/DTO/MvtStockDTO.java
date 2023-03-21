package com.gestiondestock.DTO;

import com.gestiondestock.Model.Article;
import com.gestiondestock.Model.MvtStock;
import com.gestiondestock.Model.SourceMvtStk;
import com.gestiondestock.Model.TypeMvtStk;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStockDTO {
    private Integer id;
    private Instant dateMvt;
    private BigDecimal quantite;
    private ArticleDTO article;
    private TypeMvtStk typeMvt;
    private SourceMvtStk sourceMvt;
    public static MvtStockDTO fromEntity(MvtStock mvtStk) {
        if (mvtStk == null) {
            return null;
        }

        return MvtStockDTO.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleDTO.fromEntity(mvtStk.getArticle()))
                .typeMvt(mvtStk.getTypeMvt())
                .sourceMvt(mvtStk.getSourceMvt())
                .build();
    }

    public static MvtStock toEntity(MvtStockDTO dto) {
        if (dto == null) {
            return null;
        }

        MvtStock mvtStk = new MvtStock();
        mvtStk.setId(dto.getId());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setQuantite(dto.getQuantite());
        mvtStk.setArticle(ArticleDTO.toEntity(dto.getArticle()));
        mvtStk.setTypeMvt(dto.getTypeMvt());
        mvtStk.setSourceMvt(dto.getSourceMvt());
        return mvtStk;
    }

}
