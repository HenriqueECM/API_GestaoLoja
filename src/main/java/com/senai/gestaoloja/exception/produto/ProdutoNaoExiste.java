package com.senai.gestaoloja.exception.produto;

public class ProdutoNaoExiste extends RuntimeException{
    public ProdutoNaoExiste (){
        super ("Produto não encontrado. Verifique o nome ou código e tente novamente.");
    }
}
