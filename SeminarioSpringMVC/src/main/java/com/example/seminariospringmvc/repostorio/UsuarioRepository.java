package com.example.seminariospringmvc.repostorio;

import com.example.seminariospringmvc.encapsulaciones.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, String> {

    List<Usuario> findAll();
    void deleteById(Long id);
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByUsername(String username);




}
