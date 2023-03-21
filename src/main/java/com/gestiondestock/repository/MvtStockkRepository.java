package com.gestiondestock.repository;

import java.math.BigDecimal;
import java.util.List;

import com.gestiondestock.Model.MvtStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MvtStockkRepository extends JpaRepository<MvtStock, Integer> {

  @Query("select sum(m.quantite) from MvtStock m where m.article.id = :idArticle")
  BigDecimal stockReelArticle(@Param("idArticle") Integer idArticle);

  List<MvtStock> findAllByArticleId(Integer idArticle);

}
