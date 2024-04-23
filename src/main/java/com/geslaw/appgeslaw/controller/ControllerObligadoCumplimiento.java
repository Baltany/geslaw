package com.geslaw.appgeslaw.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;


import com.geslaw.appgeslaw.model.Empresa;
import com.geslaw.appgeslaw.model.ObligadoCumplimiento;
import com.geslaw.appgeslaw.model.Sede;
import com.geslaw.appgeslaw.model.Territorio;
import com.geslaw.appgeslaw.model.Usuario;
import com.geslaw.appgeslaw.repo.RepoEmpresa;
import com.geslaw.appgeslaw.repo.RepoObligadoCumplimiento;
import com.geslaw.appgeslaw.repo.RepoSede;
import com.geslaw.appgeslaw.repo.RepoTerritorio;
import com.geslaw.appgeslaw.repo.RepoUsuario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/obligadocumplimientos")
public class ControllerObligadoCumplimiento {
    @Autowired
    private RepoObligadoCumplimiento repoObligadoCumplimiento;
    @Autowired
    private RepoEmpresa repoEmpresa;
    @Autowired
    private RepoSede repoSede;
    @Autowired
    private RepoTerritorio repoTerritorio;
    @Autowired
    private RepoUsuario repoUsuario;

    @PreAuthorize("hasAnyAuthority('Admin','Coordinador','Director','Trabajador')")
    @GetMapping("")
    public String findAll(Model modelo) {
        modelo.addAttribute("obligadocumplimientos", repoObligadoCumplimiento.findAll());
        return "obligadocumplimientos/obligadocumplimientos";
    }

    //con obligadoCumplimiento si muestra el add y new ObligadCumplimiento con el findAll() falla
    @PreAuthorize("hasAnyAuthority('Admin','Coordinador','Director')")
    @GetMapping("/add")
    public String mostrarFormulario(Model modelo){
        List<Empresa> empresas = repoEmpresa.findAll(); // Obtener todas las empresas
        List<Sede> sedes = repoSede.findAll(); // Obtener todas las sedes
        List<Territorio> territorios = repoTerritorio.findAll(); // Obtener todas los territorios
        List<Usuario> usuarios = repoUsuario.findAll(); // Obtener todos los usuarios
        modelo.addAttribute("empresas", empresas);
        modelo.addAttribute("sedes", sedes);
        modelo.addAttribute("territorios", territorios);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("obligadoCumplimiento", new ObligadoCumplimiento());
        return "obligadocumplimientos/add";
}



    @PreAuthorize("hasAnyAuthority('Admin','Coordinador','Director')")
    @PostMapping("/add")
    public String addObligadoCumplimiento(
            @ModelAttribute("obligadoCumplimiento") ObligadoCumplimiento obligadoCumplimiento,
            @RequestParam("empresa") Long empresaId,
            @RequestParam("sede") Long sedeId,
            @RequestParam("territorio") Long territorioId,
            // @RequestParam("usuario") Long usuarioId,
            @RequestParam("fichero") MultipartFile multipartFile,
            @RequestParam("aplica") boolean aplica,
            @RequestParam("favorable") boolean favorable,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "obligadocumplimientos/add";
        }

        Empresa empresa = repoEmpresa.findById(empresaId).orElse(null);
        Sede sede = repoSede.findById(sedeId).orElse(null);
        Territorio territorio = repoTerritorio.findById(territorioId).orElse(null);
        // Usuario usuario = repoUsuario.findById(usuarioId).orElse(null);

        if (empresa == null || sede == null || territorio == null) {
            model.addAttribute("error", "No se encontró una o más entidades relacionadas");
            return "error";
        }

        obligadoCumplimiento.setEmpresa(empresa);
        obligadoCumplimiento.setSede(sede);
        obligadoCumplimiento.setTerritorio(territorio);
        // obligadoCumplimiento.setUsuario(usuario);
        obligadoCumplimiento.setAplica(aplica);
        obligadoCumplimiento.setFavorable(favorable);

        // Asignar el archivo multipartFile a la propiedad fichero
        obligadoCumplimiento.setFichero(multipartFile);

        // Guardar el objeto en la base de datos
        repoObligadoCumplimiento.save(obligadoCumplimiento);

        return "redirect:/obligadocumplimientos";
    }


    // @PostMapping("/add")
    // public String addObligadoCumplimiento(@ModelAttribute("obligadocumplimientos") 
    // @NonNull ObligadoCumplimiento obligadoCumplimiento)
    // {
    //     repoObligadoCumplimiento.save(obligadoCumplimiento);
    //     return "redirect:/obligadocumplimientos";
    // }

    //Lógica para poder recoger un archivo
    // @PostMapping("/obligadocumplimientos/add")
    // public String addObligadoCumplimiento(@ModelAttribute("obligadoCumplimiento") ObligadoCumplimiento obligadoCumplimiento) {
    //     // Aquí puedes procesar y guardar el objeto `obligadoCumplimiento` en la base de datos
    //     MultipartFile file = obligadoCumplimiento.getFile();
    //     // Procesar el archivo según sea necesario

    //     // Guardar el objeto en la base de datos o realizar otras operaciones

    //     return "redirect:/obligadoCumplimientos"; // Redirigir a la lista de obligados cumplimiento
    // }


    // @GetMapping("/delete/{id}")
    // public String deleteForm(@PathVariable(name = "id") @NonNull Long id,Model modelo) {
    //     try{
    //         Optional<ObligadoCumplimiento> obligadoCumplimiento = repoObligadoCumplimiento.findById(id);
    //         if(obligadoCumplimiento.isPresent()){
    //             modelo.addAttribute("obligadocumplimiento", obligadoCumplimiento.get());
    //             return "obligadocumplimientos/delete";
    //         }else{
    //             return "error";
    //         }
    //     }catch(Exception e){
    //         return "error";
    //     }
    // }

    @PostMapping("/delete/{id}")
    public String deleteObligado (@PathVariable Long id,RedirectAttributes redirectAttributes){
        try{
            Optional<ObligadoCumplimiento> obligadoCumplimientoOptional = repoObligadoCumplimiento.findById(id);
            
            if(obligadoCumplimientoOptional.isPresent()){
                ObligadoCumplimiento obligadoCumplimiento = obligadoCumplimientoOptional.get();
                repoObligadoCumplimiento.delete(obligadoCumplimiento);
                redirectAttributes.addFlashAttribute("successMessage", "Obligado Cumplimiento eliminado correctamente");

            }else{
                redirectAttributes.addFlashAttribute("errorMessage", "Obligado Cumplimiento no encontrado");
            }
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", "Erro al intentar borrar el Obligado Cumplimiento");
        }
        return "redirect:/obligadocumplimientos";
    }


    @PreAuthorize("hasAnyAuthority('Admin', 'Coordinador')")
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable @NonNull Long id, Model model) {
        
        Optional<ObligadoCumplimiento> optionalObligado = repoObligadoCumplimiento.findById(id);
        List<ObligadoCumplimiento> obligadoCumplimientos = repoObligadoCumplimiento.findAll();
        List<Empresa> empresas = repoEmpresa.findAll();
        List<Sede> sedes = repoSede.findAll();
        List<Territorio> territorios = repoTerritorio.findAll();
        List<Usuario> usuarios = repoUsuario.findAll();

        if (optionalObligado.isPresent()) {
            ObligadoCumplimiento obligadoCumplimiento = optionalObligado.get();
            model.addAttribute("obligadoCumplimiento", obligadoCumplimiento);
            model.addAttribute("obligadocumplimientos", obligadoCumplimientos);
            model.addAttribute("empresas", empresas);
            model.addAttribute("sedes", sedes);
            model.addAttribute("territorios", territorios);
            model.addAttribute("usuarios", usuarios);
            return "obligadocumplimientos/edit";
        } else {
            model.addAttribute("mensaje", "Obligado de cumplimiento no encontrado");
            return "error";
        }
    }

    
    
}
































