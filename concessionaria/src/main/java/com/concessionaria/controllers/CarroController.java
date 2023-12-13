package com.concessionaria.controllers;

import java.net.URI;
import java.util.List;

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
public class CarroController {

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
}
