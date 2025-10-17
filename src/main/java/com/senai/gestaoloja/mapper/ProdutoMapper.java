package com.senai.gestaoloja.mapper;

import com.senai.gestaoloja.dto.request.ProdutoRequest;
import com.senai.gestaoloja.dto.response.ProdutoResponse;
import com.senai.gestaoloja.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public Produto paraEntidade(ProdutoRequest request){
        return new Produto(request.nome(), request.descricao(), request.preco(), request.quantidade());
    }

    public ProdutoResponse paraResposta(Produto produto){
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQuantidade());
    }
}
