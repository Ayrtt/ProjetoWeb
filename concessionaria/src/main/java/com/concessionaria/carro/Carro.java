package com.concessionaria.carro;

import com.concessionaria.anunciante.Anunciante;
import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Table(name="carros")
@Entity(name = "Carro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Carro {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String marca;
  private String modelo;
  private int ano;
  private double preco;

  @ManyToOne
  @JoinColumn(name="id_anunciante")
  private Anunciante anunciante;

  public Carro(DadosCadastroCarro dados) {
    this.marca = dados.marca();
    this.modelo = dados.modelo();
    this.ano = dados.ano();
    this.preco = dados.preco();
  }

  public String getMarca(){
    return marca;
  }

  public String getModelo(){
    return modelo;
  }

  public int getAno(){
    return ano;
  }

  public double getPreco(){
    return preco;
  }

}
