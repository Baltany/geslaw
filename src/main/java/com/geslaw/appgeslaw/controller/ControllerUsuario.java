package com.geslaw.appgeslaw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import com.geslaw.appgeslaw.model.Sede;
import com.geslaw.appgeslaw.model.TipoUsuario;
import com.geslaw.appgeslaw.model.Usuario;
import com.geslaw.appgeslaw.repo.RepoFactura;
import com.geslaw.appgeslaw.repo.RepoObligadoCumplimiento;
import com.geslaw.appgeslaw.repo.RepoSede;
import com.geslaw.appgeslaw.repo.RepoTipoUsuario;
import com.geslaw.appgeslaw.repo.RepoUsuario;
import com.geslaw.appgeslaw.service.ServiceUsuario;

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

    // @Autowired
    // private ServiceUsuario userService;


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

    //muestra la sede a la que pertenece cada usuario
@GetMapping("/index")
public String paginaInicio(Model model, Authentication authentication) {
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    Usuario usuario = repoUsuario.findByUsername(userDetails.getUsername());
    
    // Cargar la lista de sedes asociadas al usuario
    List<Sede> sedes = usuario.getSede();
    
    model.addAttribute("usuario", usuario);
    model.addAttribute("sedes", sedes); // Agregar las sedes al modelo

    return "index";
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
        //Encryptamos la password
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        repoUsuario.save(usuario);

        return "redirect:/usuarios/";
    }




    // Método para manejar la solicitud DELETE para eliminar un usuario por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") Long id) {
        try {
            // Buscar el usuario por su ID en la base de datos
            Usuario usuario = repoUsuario.findById(id).orElse(null);
    
            // Verificar si el usuario existe
            if (usuario!= null) {
                // Eliminar el usuario de la base de datos
                repoUsuario.delete(usuario);
                return ResponseEntity.ok("Usuario eliminado exitosamente");
            } else {
                return ResponseEntity.notFound().build(); // Usuario no encontrado
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el usuario: " + e.getMessage());
        }
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

    Optional<Usuario> oUsuario = repoUsuario.findById(id);
    if (oUsuario.isPresent()) {
        Usuario existingUsuario = oUsuario.get();
        
        // Actualizar campos editables del usuario
        existingUsuario.setUsername(usuario.getUsername());
        existingUsuario.setNombre(usuario.getNombre());
        existingUsuario.setApellidos(usuario.getApellidos());
        existingUsuario.setDni(usuario.getDni());
        existingUsuario.setEmail(usuario.getEmail());

        // Limpiar la lista de tipos de usuario existente
        existingUsuario.getTipoUsuario().clear();
        
        // Asignar los nuevos tipos de usuario seleccionados al usuario existente
        List<TipoUsuario> tiposSeleccionados = usuario.getTipoUsuario();
        tiposSeleccionados.forEach(tipo -> existingUsuario.getTipoUsuario().add(tipo));

        // Guardar los cambios en el usuario existente
        repoUsuario.save(existingUsuario);
        
        return "redirect:/usuarios/";
    } else {
        model.addAttribute("mensaje", "El usuario a actualizar no existe.");
        return "error";
    }
}


@PostMapping("/edit/{id}")
public String updateUsuarioPass(@ModelAttribute("usuario") @Validated Usuario usuario, BindingResult result, @PathVariable("id") Long id, Model model) {
    if (result.hasErrors()) {
        return "usuarios/edit"; // Volver a mostrar el formulario de edición con errores
    }

    Optional<Usuario> oUsuario = repoUsuario.findById(id);
    if (oUsuario.isPresent()) {
        Usuario existingUsuario = oUsuario.get();
        
        // Actualizar campos editables del usuario
        existingUsuario.setUsername(usuario.getUsername());
        existingUsuario.setNombre(usuario.getNombre());
        existingUsuario.setApellidos(usuario.getApellidos());
        existingUsuario.setDni(usuario.getDni());
        existingUsuario.setEmail(usuario.getEmail());

        //Seguramente esté mal pero hay que comprobarlo
        existingUsuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));

        // Limpiar la lista de tipos de usuario existente
        existingUsuario.getTipoUsuario().clear();
        
        // Asignar los nuevos tipos de usuario seleccionados al usuario existente
        List<TipoUsuario> tiposSeleccionados = usuario.getTipoUsuario();
        tiposSeleccionados.forEach(tipo -> existingUsuario.getTipoUsuario().add(tipo));

        // Guardar los cambios en el usuario existente
        repoUsuario.save(existingUsuario);
        
        return "redirect:/usuarios/";
    } else {
        model.addAttribute("mensaje", "El usuario a actualizar no existe.");
        return "error";
    }
}

    
}
