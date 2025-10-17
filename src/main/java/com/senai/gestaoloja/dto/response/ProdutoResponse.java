package com.senai.gestaoloja.dto.response;

public record ProdutoResponse(
        Long id,
        String nome,
        String descricao,
        Double preco,
        Integer quantidade
) {
}
