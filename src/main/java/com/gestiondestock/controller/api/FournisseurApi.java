package com.gestiondestock.controller.api;


import com.gestiondestock.DTO.FournisseurDTO;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.gestiondestock.utils.Constants.FOURNISSEUR_ENDPOINT;

@Api("fournisseur")
public interface FournisseurApi {

  @PostMapping(FOURNISSEUR_ENDPOINT + "/create")
  FournisseurDTO save(@RequestBody FournisseurDTO dto);

  @GetMapping(FOURNISSEUR_ENDPOINT + "/{idFournisseur}")
  FournisseurDTO findById(@PathVariable("idFournisseur") Integer id);

  @GetMapping(FOURNISSEUR_ENDPOINT + "/all")
  List<FournisseurDTO> findAll();

  @DeleteMapping(FOURNISSEUR_ENDPOINT + "/delete/{idFournisseur}")
  void delete(@PathVariable("idFournisseur") Integer id);

}
