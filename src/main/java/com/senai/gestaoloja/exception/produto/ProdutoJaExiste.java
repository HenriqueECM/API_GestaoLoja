package com.senai.gestaoloja.exception.produto;

public class ProdutoJaExiste extends RuntimeException{
    public ProdutoJaExiste(){
        super("Produto já cadastrado. Utilize um nome ou código diferente");
    }
}
