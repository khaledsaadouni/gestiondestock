package com.gestiondestock.controller;

import java.util.List;

import com.gestiondestock.DTO.ClientDTO;
import com.gestiondestock.controller.api.ClientApi;
import com.gestiondestock.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController implements ClientApi {

  private ClientService clientService;

  @Autowired
  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @Override
  public ClientDTO save(ClientDTO dto) {
    return clientService.save(dto);
  }

  @Override
  public ClientDTO findById(Integer id) {
    return clientService.findById(id);
  }

  @Override
  public List<ClientDTO> findAll() {
    return clientService.findAll();
  }

  @Override
  public void delete(Integer id) {
    clientService.delete(id);
  }
}
