package com.gestiondestock.services;

import com.gestiondestock.DTO.ClientDTO;

import java.util.List;

public interface ClientService {

  ClientDTO save(ClientDTO dto);

  ClientDTO findById(Integer id);

  List<ClientDTO> findAll();

  void delete(Integer id);

}
