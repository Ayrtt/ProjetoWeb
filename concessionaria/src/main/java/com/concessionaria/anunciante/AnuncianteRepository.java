package com.concessionaria.anunciante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncianteRepository extends JpaRepository<Anunciante,Integer> {
  Anunciante findByEmailAndSenha(String email, String senha);
}