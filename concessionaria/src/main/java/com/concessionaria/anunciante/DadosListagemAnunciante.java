package com.concessionaria.anunciante;

public record DadosListagemAnunciante(
        Integer id, // o id tem que vim pq as operações são feitas por id, busca por id, validação
                    // por id etc; Aí com o id do anunciante a gente cadastra o carro; Esse record é
                    // um DTO que serve pra várias coisas e dentre elas seguir o padrão DTO;
        String nome,
        String telefone,
        String rua,
        String numero,
        String bairro) {

    public DadosListagemAnunciante(Anunciante anunciante) {
        this(
                anunciante.getId(),
                anunciante.getNome(),
                anunciante.getTelefone(),
                anunciante.getRua(),
                anunciante.getNumero(),
                anunciante.getBairro());
    }
}
