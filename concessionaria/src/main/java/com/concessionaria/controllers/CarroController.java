package com.concessionaria.controllers;

<<<<<<< HEAD
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

=======
import java.net.URI;
>>>>>>> origin/main
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.concessionaria.anunciante.Anunciante;
import com.concessionaria.anunciante.AnuncianteRepository;
import com.concessionaria.carro.Carro;
import com.concessionaria.carro.CarroRepository;
import com.concessionaria.carro.DadosCadastroCarro;
import com.concessionaria.carro.DadosListagemCarro;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("carros")
@CrossOrigin(origins = "*")
public class CarroController {

<<<<<<< HEAD
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
=======
    @Autowired
    private CarroRepository repository;

    @Autowired
    private AnuncianteRepository anuncianteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemCarro> cadastrar(@RequestBody @Valid DadosCadastroCarro dados) {
        System.out.println("Adicionando carro ao banco: " + dados);

        // Antes de salvar o carro a gente precisa setar o anunciante dele que veio por
        // id na requisição;
        Anunciante anunciante = anuncianteRepository.findById(dados.anuncianteId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anunciante não encontrado"));

        // Agora a gente faz um carro, seta o anunciante dele pq ele tem um objeto
        // anunciante por composição e depois salva o carro no banco de dados;
        Carro carro = new Carro(dados);
        carro.setAnunciante(anunciante);

        repository.save(carro); // agora é só salvar e retornar na requisição post pra seguir o padrão http de
                                // apis rest;

        // isso aqui é a montagem da uri de acesso ao carro criado, é mais o menos o
        // padrão hateoas;
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carro.getId())
                .toUri();

        DadosListagemCarro dadosListagemCarro = new DadosListagemCarro(carro.getId(), carro.getMarca(),
                carro.getModelo(), carro.getAno(), carro.getPreco(), carro.getAnunciante().getId());

        return ResponseEntity.created(uri).body(dadosListagemCarro);
    }

    @GetMapping
    public List<Carro> listar() {
        return repository.findAll();
    }
>>>>>>> origin/main
}
