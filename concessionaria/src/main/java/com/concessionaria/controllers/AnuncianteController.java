package com.concessionaria.controllers;

import com.concessionaria.anunciante.*;
import jakarta.validation.Valid;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("anunciantes")
@CrossOrigin(origins = "*")
public class AnuncianteController {
  @Autowired
  private AnuncianteRepository repository;

  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastroAnunciante dados){
    System.out.println("Adicionando anunciante ao banco: " + dados);
    repository.save(new Anunciante(dados));
  }

  @GetMapping
  public List<Anunciante> listar() {
    return repository.findAll();
  }

  @GetMapping("/anunciantescomcarros")
  public ResponseEntity<List<DadosListagemAnunciante>> obterAnunciantesComCarros() {
    List<DadosListagemAnunciante> anunciantesDTO = repository.findAll()
                          .stream().map(DadosListagemAnunciante::new)
                          .collect(Collectors.toList());
    return new ResponseEntity<>(anunciantesDTO, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public Anunciante pegarPorId(@PathVariable Integer id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Anunciante não encontrado"));
  }

  @PostMapping("/autenticar")
  public ResponseEntity<Integer> autenticar(@RequestBody DadosAutenticacao dados) {
    Anunciante anunciante = repository.findByEmailAndSenha(dados.email(), dados.senha());
    if (anunciante != null) {
      return new ResponseEntity<>(anunciante.getId(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
  }
}
