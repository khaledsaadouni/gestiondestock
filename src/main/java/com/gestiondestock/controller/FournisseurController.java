package com.gestiondestock.controller;

import java.util.List;

import com.gestiondestock.DTO.FournisseurDTO;
import com.gestiondestock.controller.api.FournisseurApi;
import com.gestiondestock.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FournisseurController implements FournisseurApi {

  private FournisseurService fournisseurService;

  @Autowired
  public FournisseurController(FournisseurService fournisseurService) {
    this.fournisseurService = fournisseurService;
  }

  @Override
  public FournisseurDTO save(FournisseurDTO dto) {
    return fournisseurService.save(dto);
  }

  @Override
  public FournisseurDTO findById(Integer id) {
    return fournisseurService.findById(id);
  }

  @Override
  public List<FournisseurDTO> findAll() {
    return fournisseurService.findAll();
  }

  @Override
  public void delete(Integer id) {
    fournisseurService.delete(id);
  }
}
