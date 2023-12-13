package com.concessionaria.carro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCarro(
<<<<<<< HEAD
  
  @NotBlank String marca,
  @NotBlank String modelo,
  @NotBlank String foto,
  @NotNull int ano, 
  @NotNull double preco,
  @NotNull Integer id_anunciante
  
) {}
=======

        @NotBlank String marca,
        @NotBlank String modelo,
        @NotNull int ano,
        @NotNull double preco,
        @NotNull Integer anuncianteId

) {
}
>>>>>>> origin/main
