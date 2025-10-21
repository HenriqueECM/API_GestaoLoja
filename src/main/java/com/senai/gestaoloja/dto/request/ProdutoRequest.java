package com.senai.gestaoloja.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProdutoRequest(
        // colocar validações aqui
        @NotNull(message = "O nome deve ser informado.")
        @NotBlank(message = "O nome do produto é obrigatório.")
        String nome,

        @NotBlank
        String descricao,
        @NotNull(message = "O preço deve ser informado.")
        @Positive(message = "O preço deve ser maior que zero.")
        Double preco,

        @NotNull(message = "A quantidade deve ser informado.")
        @Positive(message = "A quantidade deve ser maior que zero.")
        Integer quantidade
) {
}
