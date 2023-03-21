package com.gestiondestock.services.strategy;
import com.flickr4java.flickr.FlickrException;
import java.io.InputStream;

import com.gestiondestock.DTO.EntrepriseDTO;
import com.gestiondestock.exception.ErrorCodes;
import com.gestiondestock.exception.InvalidOperationException;
import com.gestiondestock.services.EntrepriseService;
import com.gestiondestock.services.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("entrepriseStrategy")
@Slf4j
public class SaveEntreprisePhoto implements Strategy<EntrepriseDTO> {

  private FlickrService flickrService;
  private EntrepriseService entrepriseService;

  @Autowired
  public SaveEntreprisePhoto(FlickrService flickrService, EntrepriseService entrepriseService) {
    this.flickrService = flickrService;
    this.entrepriseService = entrepriseService;
  }

  @Override
  public EntrepriseDTO savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
    EntrepriseDTO entreprise = entrepriseService.findById(id);
    String urlPhoto = flickrService.savePhoto(photo, titre);
    if (!StringUtils.hasLength(urlPhoto)) {
      throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de l'entreprise", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
    }
    entreprise.setPhoto(urlPhoto);
    return entrepriseService.save(entreprise);
  }
}
