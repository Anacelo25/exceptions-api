package com.avalia.exceptions.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.pedidos WHERE u.id = ?1")
    Optional<Usuario> findUsuarioWithPedido(Long id);
}