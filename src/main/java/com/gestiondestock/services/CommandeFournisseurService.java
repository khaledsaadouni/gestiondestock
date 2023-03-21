package com.gestiondestock.services;

import com.gestiondestock.DTO.CommandeFournisseurDTO;
import com.gestiondestock.DTO.LigneCommandeFournisseurDTO;
import com.gestiondestock.Model.EtatCommande;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeFournisseurService {

  CommandeFournisseurDTO save(CommandeFournisseurDTO dto);

  CommandeFournisseurDTO updateEtatCommande(Integer idCommande, EtatCommande etatCommande);

  CommandeFournisseurDTO updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite);

  CommandeFournisseurDTO updateFournisseur(Integer idCommande, Integer idFournisseur);

  CommandeFournisseurDTO updateArticle(Integer idCommande, Integer idLigneCommande, Integer idArticle);

  // Delete article ==> delete LigneCommandeFournisseur
  CommandeFournisseurDTO deleteArticle(Integer idCommande, Integer idLigneCommande);

  CommandeFournisseurDTO findById(Integer id);

  CommandeFournisseurDTO findByCode(String code);

  List<CommandeFournisseurDTO> findAll();

  List<LigneCommandeFournisseurDTO> findAllLignesCommandesFournisseurByCommandeFournisseurId(Integer idCommande);

  void delete(Integer id);

}
