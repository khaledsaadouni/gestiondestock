package com.gestiondestock.controller;

import java.math.BigDecimal;
import java.util.List;

import com.gestiondestock.DTO.MvtStockDTO;
import com.gestiondestock.controller.api.MvtStkApi;
import com.gestiondestock.services.MvtStkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MvtStkController implements MvtStkApi {

  private MvtStkService service;

  @Autowired
  public MvtStkController(MvtStkService service) {
    this.service = service;
  }

  @Override
  public BigDecimal stockReelArticle(Integer idArticle) {
    return service.stockReelArticle(idArticle);
  }

  @Override
  public List<MvtStockDTO> mvtStkArticle(Integer idArticle) {
    return service.mvtStkArticle(idArticle);
  }

  @Override
  public MvtStockDTO entreeStock(MvtStockDTO dto) {
    return service.entreeStock(dto);
  }

  @Override
  public MvtStockDTO sortieStock(MvtStockDTO dto) {
    return service.sortieStock(dto);
  }

  @Override
  public MvtStockDTO correctionStockPos(MvtStockDTO dto) {
    return service.correctionStockPos(dto);
  }

  @Override
  public MvtStockDTO correctionStockNeg(MvtStockDTO dto) {
    return service.correctionStockNeg(dto);
  }
}
