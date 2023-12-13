package com.concessionaria.carro;

<<<<<<< HEAD
import com.concessionaria.anunciante.Anunciante;

public record DadosListagemCarro(String marca, String modelo, String foto, int ano, 
                                 double preco, Anunciante anunciante) {

  public DadosListagemCarro(Carro carro){
    this( carro.getMarca(), carro.getModelo(), carro.getFoto(), carro.getAno(),
          carro.getPreco(), carro.getAnunciante() );
  }
=======
public record DadosListagemCarro(
        Integer id,
        String marca,
        String modelo,
        int ano,
        double preco,
        int idAnunciante) {

    public DadosListagemCarro(Carro carro) {
        this(
                carro.getId(),
                carro.getMarca(),
                carro.getModelo(),
                carro.getAno(),
                carro.getPreco(),
                carro.getIdAnunciante());
    }
>>>>>>> origin/main
}