package com.concessionaria.carro;

import com.concessionaria.anunciante.Anunciante;
import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
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
  private int id;
  
  private String marca;
  private String modelo;
  private int ano;
  private double preco;
  @Column(insertable=false, updatable=false)
  private int id_anunciante;

  @ManyToOne
  @JoinColumn(name="id_anunciante")
  private Anunciante anunciante;

  public Carro(DadosCadastroCarro dados) {
    this.marca = dados.marca();
    this.modelo = dados.modelo();
    this.ano = dados.ano();
    this.preco = dados.preco();
    this.id_anunciante = anunciante.getId();
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

  public int getIdAnunciante(){
    return anunciante.getId();
  }
}
