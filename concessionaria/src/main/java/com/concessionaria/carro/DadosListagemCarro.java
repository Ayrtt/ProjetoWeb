package com.concessionaria.carro;

import com.concessionaria.anunciante.Anunciante;

public record DadosListagemCarro(String marca, String modelo, String foto, int ano, 
                                 double preco, Anunciante anunciante) {

  public DadosListagemCarro(Carro carro){
    this( carro.getMarca(), carro.getModelo(), carro.getFoto(), carro.getAno(),
          carro.getPreco(), carro.getAnunciante() );
  }
}