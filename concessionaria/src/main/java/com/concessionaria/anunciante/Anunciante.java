package com.concessionaria.anunciante;

import java.util.List;

import com.concessionaria.carro.Carro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "anunciantes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Anunciante {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

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

  public Anunciante(DadosCadastroAnunciante dados) {
    this.nome = dados.nome();
    this.email = dados.email();
    this.cpf = dados.cpf();
    this.telefone = dados.telefone();
    this.rua = dados.rua();
    this.numero = dados.numero();
    this.bairro = dados.bairro();
    this.funcao = dados.funcao();
  }

  public List<Carro> getCarros() {
    return carros;
  }

  public String getNome() {
    return nome;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getRua() {
    return rua;
  }

  public String getNumero() {
    return numero;
  }

  public String getBairro() {
    return bairro;
  }

  public int getId() {
    return id;
  }
}
