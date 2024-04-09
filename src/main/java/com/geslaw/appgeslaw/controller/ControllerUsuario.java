package com.geslaw.appgeslaw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geslaw.appgeslaw.model.TipoUsuario;
import com.geslaw.appgeslaw.model.Usuario;
import com.geslaw.appgeslaw.repo.RepoFactura;
import com.geslaw.appgeslaw.repo.RepoObligadoCumplimiento;
import com.geslaw.appgeslaw.repo.RepoSede;
import com.geslaw.appgeslaw.repo.RepoTipoUsuario;
import com.geslaw.appgeslaw.repo.RepoUsuario;

import jakarta.persistence.ManyToMany;

@Controller
@RequestMapping("/usuarios")
public class ControllerUsuario {

    /*Falta login,registro y manejo de excepciones*/
    @Autowired private RepoUsuario repoUsuario;

    @Autowired private RepoTipoUsuario repoTipoUsuario;

    @Autowired private RepoSede repoSede;

    @Autowired private RepoObligadoCumplimiento repoObligadoCumplimiento;

    @Autowired private RepoFactura repoFactura;

    @ManyToMany
    private List<TipoUsuario> tipoUsuario;


    @GetMapping(path = "/")
    public String findAll(Model model) {
        List<Usuario> listaUsuarios = repoUsuario.findAll();
        model.addAttribute("usuarios", listaUsuarios);
        return "usuarios/usuarios";
    }

    @GetMapping("")
    public String findAll2(Model model) {
        return findAll(model);
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("tiposUsuarios", repoTipoUsuario.findAll());
        model.addAttribute("sede", repoSede.findAll());
        model.addAttribute("obligadocumplimiento", repoObligadoCumplimiento.findAll());
        model.addAttribute("factura", repoFactura.findAll());
        return "usuarios/add";
    }

    //Falta validar que si el usuario que se va a añadir ya existe
    @PostMapping("/add")
    public String addUsuario(@ModelAttribute("usuario") @Validated Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            // Si hay errores de validación, volver a mostrar el formulario con los mensajes de error
            return "usuarios/add";
        }
        repoUsuario.save(usuario);

        return "redirect:/usuarios/";
    }



    

    //quiero que haga el post
    // @GetMapping("/delete/{id}")
    // public String deleteUsuarioForm(
    //     Model modelo,
    //     @PathVariable("id") @NonNull Long id
    // ) {
    //     Optional<Usuario> oUsuario = repoUsuario.findById(id);
    //     if (oUsuario.isPresent()) 
    //         modelo.addAttribute("usuario", oUsuario.get());
    //     else {
    //         modelo.addAttribute("mensaje", "El usuario consultado no existe.");
    //         return "error";
    //     }
    //     return "usuarios/delete";
    // }

    @DeleteMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable("id") @NonNull Long id) {
    repoUsuario.deleteById(id);
    return "redirect:/usuarios";
}





@GetMapping("/edit/{id}")
public String editUsuarioForm(Model model, @PathVariable("id") @NonNull Long id) {
    Optional<Usuario> oUsuario = repoUsuario.findById(id);
    if (oUsuario.isPresent()) {
        Usuario usuario = oUsuario.get();
        model.addAttribute("usuario", usuario);
        model.addAttribute("tiposUsuarios", repoTipoUsuario.findAll());
        model.addAttribute("sede", repoSede.findAll());
        model.addAttribute("obligadocumplimiento", repoObligadoCumplimiento.findAll());
        model.addAttribute("factura", repoFactura.findAll());
        return "usuarios/edit";
    } else {
        model.addAttribute("mensaje", "El usuario consultado no existe.");
        return "error";
    }
}

@PostMapping("/update/{id}")
public String updateUsuario(@ModelAttribute("usuario") @Validated Usuario usuario, BindingResult result, @PathVariable("id") Long id, Model model) {
    if (result.hasErrors()) {
        return "usuarios/edit"; // Volver a mostrar el formulario de edición con errores
    }

    // Actualizar el usuario en la base de datos
    Optional<Usuario> oUsuario = repoUsuario.findById(id);
    if (oUsuario.isPresent()) {
        Usuario existingUsuario = oUsuario.get();
        existingUsuario.setUsername(usuario.getUsername());
        existingUsuario.setNombre(usuario.getNombre());
        existingUsuario.setApellidos(usuario.getApellidos());
        existingUsuario.setDni(usuario.getDni());
        existingUsuario.setEmail(usuario.getEmail());
        // Actualizar otros campos según sea necesario

        repoUsuario.save(existingUsuario);
        return "redirect:/usuarios/";
    } else {
        model.addAttribute("mensaje", "El usuario a actualizar no existe.");
        return "error";
    }
}



    

    // @GetMapping("/edit/{id}")
    // public String editUsuarioForm(
    //     Model modelo,
    //     @PathVariable("id")@NonNull Long id
    // ) {
    //     Optional<Usuario> oUsuario = repoUsuario.findById(id);
    //     if (oUsuario.isPresent()) {
    //         modelo.addAttribute("usuario", oUsuario.get());
    //         modelo.addAttribute("tipoUsuario", repoTipoUsuario.findAll());
    //         modelo.addAttribute("sede", repoSede.findAll());
    //         modelo.addAttribute("obligadocumplimiento", repoObligadoCumplimiento.findAll());
    //         modelo.addAttribute("factura", repoFactura.findAll());
    //         return "usuarios/edit";
    //     } else {
    //         modelo.addAttribute("mensaje", "El usuario consultado no existe.");
    //         return "error";
    //     }
    // }

}
