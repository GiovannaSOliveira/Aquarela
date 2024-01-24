package com.generation.aquarela.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.aquarela.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Optional<Usuario> findByUsuario(String usuario);

    public Optional<Usuario> findByNome(String nome);
}