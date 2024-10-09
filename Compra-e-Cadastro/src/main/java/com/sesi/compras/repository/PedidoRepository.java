package com.sesi.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.compras.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
