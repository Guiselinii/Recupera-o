package com.sesi.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.compras.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
