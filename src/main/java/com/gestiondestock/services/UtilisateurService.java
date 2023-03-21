package com.gestiondestock.services;

import com.gestiondestock.DTO.UtilisateurDTO;

import java.util.List;

public interface UtilisateurService {

  UtilisateurDTO save(UtilisateurDTO dto);

  UtilisateurDTO findById(Integer id);

  List<UtilisateurDTO> findAll();

  void delete(Integer id);

  UtilisateurDTO findByEmail(String email);

 // UtilisateurDTO changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);


}
