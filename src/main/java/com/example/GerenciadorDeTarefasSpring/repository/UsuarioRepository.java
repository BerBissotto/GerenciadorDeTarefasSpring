package com.example.GerenciadorDeTarefasSpring.repository;

import com.example.GerenciadorDeTarefasSpring.model.Usuario;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
