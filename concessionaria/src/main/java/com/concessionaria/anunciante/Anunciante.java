package com.concessionaria.anunciante;

import java.util.List;
import com.concessionaria.carro.Carro;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Table(name="anunciantes")
@Entity(name = "Anunciante")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Anunciante {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  private String nome;
  private String email;
  private String senha;
  private String cpf;
  private String telefone;
  private String rua;
  private String numero;
  private String bairro;
  private int funcao;

  @OneToMany(mappedBy = "anunciante", fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Carro> carros;

  public Anunciante(DadosCadastroAnunciante dados){
    this.id = dados.id();
    this.nome = dados.nome();
    this.email = dados.email();
    this.senha = dados.senha();
    this.cpf = dados.cpf();
    this.telefone = dados.telefone();
    this.rua = dados.rua();
    this.numero = dados.numero();
    this.bairro = dados.bairro();
    this.funcao = dados.funcao();
  }

  public List<Carro> getCarros(){
    return carros;
  }

  public String getNome(){
    return nome;
  }

  public String getTelefone(){
    return telefone;
  }

  public String getRua(){
    return rua;
  }

  public String getNumero(){
    return numero;
  }

  public String getBairro(){
    return bairro;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public void setTelefone(String telefone){
    this.telefone = telefone;
  }

  public void setRua(String rua){
    this.rua = rua;
  }

  public void setNumero(String numero){
    this.numero = numero;
  }

  public void setBairro(String bairro){
    this.bairro = bairro;
  }

  public int getId(){
    return id;
  }

  public void setId(int id){
    this.id = id;
  }
}
