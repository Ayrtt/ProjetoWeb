package com.concessionaria.carro;

import com.concessionaria.anunciante.Anunciante;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carros")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Carro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String marca;
  private String modelo;
  private int ano;
  private double preco;

  @ManyToOne
  @JoinColumn(name = "anunciante_id")
  private Anunciante anunciante;

  public Carro(DadosCadastroCarro dados) {
    this.marca = dados.marca();
    this.modelo = dados.modelo();
    this.ano = dados.ano();
    this.preco = dados.preco();
  }

  public String getMarca() {
    return marca;
  }

  public String getModelo() {
    return modelo;
  }

  public int getAno() {
    return ano;
  }

  public double getPreco() {
    return preco;
  }

  public int getIdAnunciante() {
    return anunciante.getId();
  }
}
