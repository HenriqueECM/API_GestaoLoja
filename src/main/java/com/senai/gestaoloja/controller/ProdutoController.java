package com.senai.gestaoloja.controller;

import com.senai.gestaoloja.dto.request.ProdutoRequest;
import com.senai.gestaoloja.dto.response.ProdutoResponse;
import com.senai.gestaoloja.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService service;
    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@RequestBody ProdutoRequest produtoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(produtoRequest));
    }
}
