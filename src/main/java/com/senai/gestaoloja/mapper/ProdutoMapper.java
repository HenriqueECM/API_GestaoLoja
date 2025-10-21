package com.senai.gestaoloja.mapper;

import com.senai.gestaoloja.dto.request.ProdutoRequest;
import com.senai.gestaoloja.dto.response.ProdutoResponse;
import com.senai.gestaoloja.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public Produto paraEntidade(ProdutoRequest request){
        if (request == null) {
            throw new IllegalArgumentException("Requisição de produto não pode ser nula.");
        }
        return new Produto(request.nome(), request.descricao(), request.preco(), request.quantidade());
    }

    public Produto verificarUpdate(ProdutoRequest request, Produto produto) {
        if (request.nome() != null && !request.nome().equals(produto.getNome())) {
            produto.setNome(request.nome());
        }

        if (request.descricao() != null && !request.descricao().equals(produto.getDescricao())) {
            produto.setDescricao(request.descricao());
        }

        if (request.preco() != null && !request.preco().equals(produto.getPreco())) {
            produto.setPreco(request.preco());
        }

        if (request.quantidade() != null && !request.quantidade().equals(produto.getQuantidade())) {
            produto.setQuantidade(request.quantidade());
        }

        return produto;
    }

    public ProdutoResponse paraResposta(Produto produto){
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQuantidade());
    }
}
