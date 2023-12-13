package com.concessionaria.controllers;

import com.concessionaria.anunciante.Anunciante;
import com.concessionaria.anunciante.AnuncianteRepository;
import com.concessionaria.carro.*;
import jakarta.validation.Valid;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("carros")
@CrossOrigin(origins = "*")
public class CarroController {

  @Autowired
  private CarroRepository repository;

  @Autowired AnuncianteRepository anuncianteRepository;
  
  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastroCarro dados){
    System.out.println("Adicionando carro ao banco: "+dados);
    
    Anunciante anunciante = anuncianteRepository.getReferenceById(dados.id_anunciante());
    Carro carro = new Carro(dados);
    carro.setAnunciante(anunciante);

    repository.save(carro);
  }

  @GetMapping
  public List<DadosListagemCarro> listar() {
    return repository.findAll()
                     .stream()
                     .map(DadosListagemCarro::new)
                     .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public DadosListagemCarro pegarPorId(@PathVariable Integer id) {
    return repository.findById(id)
                     .map(DadosListagemCarro::new)
                     .orElseThrow(() -> new RuntimeException("Carro não encontrado"));
  }
}
