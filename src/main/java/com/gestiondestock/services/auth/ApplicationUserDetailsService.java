//package com.gestiondestock.services.auth;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.gestiondestock.DTO.UtilisateurDTO;
//import com.gestiondestock.services.UtilisateurService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ApplicationUserDetailsService implements UserDetailsService {
//
//  @Autowired
//  private UtilisateurService service;
//
//
//  @Override
//  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//    UtilisateurDTO utilisateur = service.findByEmail(email);
//
//    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//    utilisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
//
//   // return new ExtendedUser(utilisateur.getEmail(), utilisateur.getMoteDePasse(), utilisateur.getEntreprise().getId(), authorities);
//return null;
//  }
//
//}
