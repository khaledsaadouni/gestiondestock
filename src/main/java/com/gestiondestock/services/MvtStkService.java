package com.gestiondestock.services;

import com.gestiondestock.DTO.MvtStockDTO;

import java.math.BigDecimal;
import java.util.List;

public interface MvtStkService {

  BigDecimal stockReelArticle(Integer idArticle);

  List<MvtStockDTO> mvtStkArticle(Integer idArticle);

  MvtStockDTO entreeStock(MvtStockDTO dto);

  MvtStockDTO sortieStock(MvtStockDTO dto);

  MvtStockDTO correctionStockPos(MvtStockDTO dto);

  MvtStockDTO correctionStockNeg(MvtStockDTO dto);


}
