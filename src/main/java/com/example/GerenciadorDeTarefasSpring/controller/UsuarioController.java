package com.example.GerenciadorDeTarefasSpring.controller;

import ch.qos.logback.core.model.Model;
import com.example.GerenciadorDeTarefasSpring.model.Usuario;
import com.example.GerenciadorDeTarefasSpring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/novo")
    public String novo(Model model){
        model.addAtribute("usuario", new Usuario());
        return "usuarios/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario usuario){
        usuarioService.salvar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuarios/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model){
        Usuario usuario = usuarioService.buscarPorId(id);
        model.addAttribute("usuario", usuario);
        return "usuarios/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        usuarioService.excluir(id);
        return "redirect:/usuarios";
    }
}
