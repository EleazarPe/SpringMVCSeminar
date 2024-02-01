package com.example.seminariospringmvc.servicios;

import com.example.seminariospringmvc.encapsulaciones.Usuario;
import com.example.seminariospringmvc.repostorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
    @Transactional
    public List<Usuario> buscarTodo(){
        return usuarioRepository.findAll();
    }
    @Transactional
    public void crearUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    @Transactional
    public Optional<Usuario> buscarUsuario(Long id){
        return usuarioRepository.findById(id);
    }

}
