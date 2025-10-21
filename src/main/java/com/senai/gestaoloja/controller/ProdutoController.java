package com.senai.gestaoloja.controller;

import com.senai.gestaoloja.dto.request.ProdutoRequest;
import com.senai.gestaoloja.dto.response.ProdutoResponse;
import com.senai.gestaoloja.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService service;
    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@RequestBody @Valid ProdutoRequest produtoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(produtoRequest));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProdutoResponse> update(@PathVariable Long id, @RequestBody @Valid ProdutoRequest produtoRequest){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, produtoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
