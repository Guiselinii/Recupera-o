package com.sesi.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.compras.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
