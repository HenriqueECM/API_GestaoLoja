package com.senai.gestaoloja.service;

import com.senai.gestaoloja.dto.request.ProdutoRequest;
import com.senai.gestaoloja.dto.response.ProdutoResponse;
import com.senai.gestaoloja.exception.produto.ProdutoJaExiste;
import com.senai.gestaoloja.mapper.ProdutoMapper;
import com.senai.gestaoloja.model.Produto;
import com.senai.gestaoloja.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoService {
    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;
    // CREATE
    public ProdutoResponse create (ProdutoRequest request){
        if (repository.existByNome(request.nome())){
            throw new ProdutoJaExiste();
        }
        return mapper.paraResposta(repository.save(mapper.paraEntidade(request)));
    }
}
