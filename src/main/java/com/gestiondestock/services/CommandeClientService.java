package com.gestiondestock.services;

import com.gestiondestock.DTO.CommandeClientDTO;
import com.gestiondestock.DTO.LigneCommandeClientDTO;
import com.gestiondestock.Model.EtatCommande;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeClientService {

  CommandeClientDTO save(CommandeClientDTO dto);

  CommandeClientDTO updateEtatCommande(Integer idCommande, EtatCommande etatCommande);

  CommandeClientDTO updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite);

  CommandeClientDTO updateClient(Integer idCommande, Integer idClient);

  CommandeClientDTO updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle);

  // Delete article ==> delete LigneCommandeClient
  CommandeClientDTO deleteArticle(Integer idCommande, Integer idLigneCommande);

  CommandeClientDTO findById(Integer id);

  CommandeClientDTO findByCode(String code);

  List<CommandeClientDTO> findAll();

  List<LigneCommandeClientDTO> findAllLignesCommandesClientByCommandeClientId(Integer idCommande);

  void delete(Integer id);

}
