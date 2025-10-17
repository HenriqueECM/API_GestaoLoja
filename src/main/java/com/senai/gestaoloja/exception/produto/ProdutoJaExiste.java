package com.senai.gestaoloja.exception.produto;

public class ProdutoJaExiste extends RuntimeException{
    public ProdutoJaExiste(){
        super("O produto já existe");
    }
}
