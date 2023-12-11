package com.concessionaria.anunciante;

import java.util.List;
import com.concessionaria.carro.Carro;

import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
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
  private String nome;
  private String email;
  private String cpf;
  private String telefone;
  private String rua;
  private String numero;
  private String bairro;
  private int funcao;

  @OneToMany(mappedBy = "anunciante")
  private List<Carro> carros;

  public Anunciante(DadosCadastroAnunciante dados){
    this.nome = dados.nome();
    this.email = dados.email();
    this.cpf = dados.cpf();
    this.telefone = dados.telefone();
    this.rua = dados.rua();
    this.numero = dados.numero();
    this.bairro = dados.bairro();
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
}
