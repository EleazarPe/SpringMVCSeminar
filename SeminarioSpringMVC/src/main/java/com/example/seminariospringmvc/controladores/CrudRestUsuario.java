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


}
