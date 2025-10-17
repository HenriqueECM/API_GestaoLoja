package com.senai.gestaoloja.repository;

import com.senai.gestaoloja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existByNome(String nome);
}
