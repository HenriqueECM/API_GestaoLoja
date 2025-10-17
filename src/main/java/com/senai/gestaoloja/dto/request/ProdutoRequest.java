package com.senai.gestaoloja.dto.request;

public record ProdutoRequest(
        String nome,
        String descricao,
        Double preco,
        Integer quantidade
) {
}
