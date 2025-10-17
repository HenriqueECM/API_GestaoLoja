package com.senai.gestaoloja.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String nome;

    @Lob
    private String descricao;

    @Column(precision = 10, scale = 2, nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer quantidade;

    public Produto(String nome, String descricao, Double preco, Integer quantidade){
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}
