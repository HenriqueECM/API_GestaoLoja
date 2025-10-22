package com.senai.gestaoloja.service;

import com.senai.gestaoloja.dto.request.ProdutoRequest;
import com.senai.gestaoloja.dto.response.ProdutoResponse;
import com.senai.gestaoloja.exception.produto.ProdutoJaExiste;
import com.senai.gestaoloja.exception.produto.ProdutoNaoExiste;
import com.senai.gestaoloja.mapper.ProdutoMapper;
import com.senai.gestaoloja.model.Produto;
import com.senai.gestaoloja.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {
    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    // CREATE
    public ProdutoResponse create (ProdutoRequest request){
        if (repository.existsByNome(request.nome())){
            throw new ProdutoJaExiste();
        }
        return mapper.paraResposta(repository.save(mapper.paraEntidade(request)));
    }

    // DELETE
    public void delete (Long id) {
        if (!repository.existsById(id)){
            throw new ProdutoNaoExiste();
        }
        repository.deleteById(id);
    }

    // BUSCAR TODOS
    public List<ProdutoResponse> buscarTodos() {
        // OPÇÃO 1
        return repository
                .findAll()
                .stream()
                .map(mapper::paraResposta)
                .toList();

        // OPÇÃO 2
//        List<Produto> produtos = repository.findAll();
//        List<ProdutoResponse> responseList = new ArrayList<>();
//        for (Produto produto : produtos){
//            responseList.add(mapper.paraResposta(produto));
//        }
//        return responseList;
    }

    // BUSCAR POR ID
    public ProdutoResponse buscarPorId(Long id) {
        // código assim é limpo, idiomático e claro
        Produto produto = repository.findById(id)
                .orElseThrow(ProdutoNaoExiste::new);

        return mapper.paraResposta(produto);
    }

    // UPDATE
    @Transactional
    // Com transação: se qualquer etapa falhar, tudo é revertido automaticamente (rollback).
    // Sem transação: você teria dados inconsistentes.
    public ProdutoResponse update(Long id, ProdutoRequest request){
        // Buscar o produto existente pelo ID
        Produto produto = repository.findById(id)
                .orElseThrow(ProdutoNaoExiste::new);

        // Atualizar os campos do produto com o mapper
        Produto produtoAtualizado = mapper.verificarUpdate(request, produto);

        // Salvar o produto atualizado no banco e retornar DTO
        return mapper.paraResposta(repository.save(produtoAtualizado));
    }
}