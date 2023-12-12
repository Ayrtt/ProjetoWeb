package com.concessionaria.anunciante;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAnunciante (

  int id,
  @NotBlank String nome,
  @NotBlank @Email String email,
  @NotBlank String cpf,
  @NotBlank String telefone,
  @NotBlank String rua,
  @NotBlank String numero,
  @NotBlank String bairro,
  @NotNull int funcao
  
){}
