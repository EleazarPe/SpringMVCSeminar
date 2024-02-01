package com.example.seminariospringmvc.controladores;

import com.example.seminariospringmvc.servicios.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud")
public class CrudController {
    @Autowired
    private UsuarioServices usuarioServices;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("usuariosAll", usuarioServices.buscarTodo());
        return "crudUsuario/index";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id){
        usuarioServices.eliminarUsuario(id);
        return "redirect:/crud";
    }
}
