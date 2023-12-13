package com.concessionaria.anunciante;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
public interface AnuncianteRepository extends JpaRepository<Anunciante,Integer> {
  Anunciante findByEmailAndSenha(String email, String senha);
=======
public interface AnuncianteRepository extends JpaRepository<Anunciante, Integer> {
>>>>>>> origin/main
}