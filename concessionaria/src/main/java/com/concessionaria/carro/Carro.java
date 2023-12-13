package com.concessionaria.carro;

import com.concessionaria.anunciante.Anunciante;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
=======

import jakarta.persistence.Entity;
>>>>>>> origin/main
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
  private String foto;
  private int ano;
  private double preco;

  @ManyToOne
<<<<<<< HEAD
  @JoinColumn(name="id_anunciante")
  @JsonBackReference
=======
  @JoinColumn(name = "anunciante_id")
>>>>>>> origin/main
  private Anunciante anunciante;

  public Carro(DadosCadastroCarro dados) {
    this.marca = dados.marca();
    this.modelo = dados.modelo();
    this.foto = dados.foto();
    this.ano = dados.ano();
    this.preco = dados.preco();
  }

  public String getMarca() {
    return marca;
  }

  public String getModelo() {
    return modelo;
  }
  
  public String getFoto(){
    return foto;
  }

  public int getAno() {
    return ano;
  }

  public double getPreco() {
    return preco;
  }

<<<<<<< HEAD
  public void setMarca(String marca){
    this.marca = marca;
  }

  public void setModelo(String modelo){
    this.modelo = modelo;
  }

  public void setFoto(String foto){
    this.foto = foto;
  }

  public void setAno(int ano){
    this.ano = ano;
  }

  public void setPreco(double preco){
    this.preco = preco;
  }

  public Anunciante getAnunciante(){
    return this.anunciante;
  }

  public void setAnunciante(Anunciante anunciante) {
    this.anunciante = anunciante;
  }

  public int getIdAnunciante(){
=======
  public int getIdAnunciante() {
>>>>>>> origin/main
    return anunciante.getId();
  }
}
