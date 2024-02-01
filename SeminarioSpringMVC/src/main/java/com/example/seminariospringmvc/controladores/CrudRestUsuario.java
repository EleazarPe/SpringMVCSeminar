package com.example.seminariospringmvc.controladores;

import com.example.seminariospringmvc.encapsulaciones.Usuario;
import com.example.seminariospringmvc.servicios.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/crud/api")
public class CrudRestUsuario {
    @Autowired
    private UsuarioServices usuarioServices;

    @PostMapping("/crear")
    public void crearUsuario(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("rol") String rol){
        usuarioServices.crearUsuario(new Usuario(username, password, rol));
    }
    @GetMapping("/visualizar/{id}")
    public Optional<Usuario> mostrarUser(@PathVariable("id") Long id){
        return usuarioServices.buscarUsuario(id);
    }
    @PutMapping("/editar/{id}")
    public void editarUsuario(@PathVariable("id") Long id, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("rol") String rol){
        System.out.println("ID: "+id+" Username: "+username+" Password: "+password+" Rol: "+rol);
        usuarioServices.buscarUsuario(id).ifPresent(usuario -> {
            usuario.setUsername(username);
            usuario.setPassword(password);
            usuario.setRol(rol);
            usuarioServices.crearUsuario(usuario);
        });
    }
    @GetMapping("buscar/{id}")
    public Optional<Usuario> buscarUsuario(@PathVariable("id") Long id){
        return usuarioServices.buscarUsuario(id);
    }


}
