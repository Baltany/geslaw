package com.geslaw.appgeslaw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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

    @GetMapping("")
    public String findAll(Model modelo) {
        modelo.addAttribute("obligadocumplimientos", repoObligadoCumplimiento.findAll());
        return "obligadocumplimientos/obligadocumplimientos";
    }

    //con obligadoCumplimiento si muestra el add y new ObligadCumplimiento con el findAll() falla
    @GetMapping("/add")
    public String addForm(Model modelo){
        modelo.addAttribute("obligadoCumplimiento", new ObligadoCumplimiento());
        return "obligadocumplimientos/add";
    }



    @PostMapping("/add")
public String addObligadoCumplimiento(@ModelAttribute("obligadoCumplimiento") ObligadoCumplimiento obligadoCumplimiento,
                                       @RequestParam("empresa") Long empresaId,
                                       @RequestParam("sede") Long sedeId,
                                       @RequestParam("territorio") Long territorioId,
                                       @RequestParam("usuario") Long usuarioId) {

    Empresa empresa = repoEmpresa.findById(empresaId).orElse(null);
    Sede sede = repoSede.findById(sedeId).orElse(null);
    Territorio territorio = repoTerritorio.findById(territorioId).orElse(null);
    Usuario usuario = repoUsuario.findById(usuarioId).orElse(null);

    obligadoCumplimiento.setEmpresa(empresa);
    obligadoCumplimiento.setSede(sede);
    obligadoCumplimiento.setTerritorio(territorio);
    obligadoCumplimiento.setUsuario(usuario);

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


    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable(name = "id") @NonNull Long id,Model modelo) {
        try{
            Optional<ObligadoCumplimiento> obligadoCumplimiento = repoObligadoCumplimiento.findById(id);
            if(obligadoCumplimiento.isPresent()){
                modelo.addAttribute("obligadocumplimiento", obligadoCumplimiento.get());
                return "obligadocumplimientos/delete";
            }else{
                return "error";
            }
        }catch(Exception e){
            return "error";
        }
    }

    @PostMapping("/delete/{id}")
    public String postMethodName(@PathVariable("id") @NonNull Long id) {
        try{
            repoObligadoCumplimiento.deleteById(id);
        }catch(Exception e){
            return "error";
        }
        return "redirect:/obligadocumplimientos";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable @NonNull Long id,Model modelo){
        Optional<ObligadoCumplimiento> obligadoCumplimiento = 
            repoObligadoCumplimiento.findById(id);
        List<ObligadoCumplimiento> obligadoCumplimientos =
            repoObligadoCumplimiento.findAll();

        if(obligadoCumplimiento.isPresent()){
            //Si ponemos obligadocumpliemiento da error solo funciona con obligadoCumpliento
            modelo.addAttribute("obligadoCumplimiento", obligadoCumplimiento.get());
            modelo.addAttribute("obligadocumplimientos", obligadoCumplimientos);
            return "obligadocumplimientos/edit";
        }else{
            modelo.addAttribute("mensaje", "obligadoCumplimiento no encontrado");
            return "error";
        }
    }
    
    
}
