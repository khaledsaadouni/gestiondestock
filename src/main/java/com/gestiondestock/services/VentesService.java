package com.gestiondestock.services;

import com.gestiondestock.DTO.VentesDTO;

import java.util.List;

public interface VentesService {

  VentesDTO save(VentesDTO dto);

  VentesDTO findById(Integer id);

  VentesDTO findByCode(String code);

  List<VentesDTO> findAll();

  void delete(Integer id);

}
