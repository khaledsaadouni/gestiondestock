package com.gestiondestock.services.strategy;

import com.flickr4java.flickr.FlickrException;
import java.io.InputStream;

import com.gestiondestock.DTO.ClientDTO;
import com.gestiondestock.exception.ErrorCodes;
import com.gestiondestock.exception.InvalidOperationException;
import com.gestiondestock.services.ClientService;
import com.gestiondestock.services.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("clientStrategy")
@Slf4j
public class SaveClientPhoto implements Strategy<ClientDTO> {

  private FlickrService flickrService;
  private ClientService clientService;

  @Autowired
  public SaveClientPhoto(FlickrService flickrService, ClientService clientService) {
    this.flickrService = flickrService;
    this.clientService = clientService;
  }

  @Override
  public ClientDTO savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
    ClientDTO client = clientService.findById(id);
    String urlPhoto = flickrService.savePhoto(photo, titre);
    if (!StringUtils.hasLength(urlPhoto)) {
      throw new InvalidOperationException("Erreur lors de l'enregistrement de photo du client", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
    }
    client.setPhoto(urlPhoto);
    return clientService.save(client);
  }
}
