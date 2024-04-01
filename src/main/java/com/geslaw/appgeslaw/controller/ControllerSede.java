package com.geslaw.appgeslaw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geslaw.appgeslaw.model.Sede;
import com.geslaw.appgeslaw.repo.RepoEmpresa;
import com.geslaw.appgeslaw.repo.RepoSede;
import com.geslaw.appgeslaw.repo.RepoTipoSede;
import com.geslaw.appgeslaw.repo.RepoUsuario;

@Controller
@RequestMapping("/sedes")
public class ControllerSede {
    @Autowired
    private RepoSede repoSede;

    @GetMapping("")
    public String findAll(Model modelo) {
        modelo.addAttribute(
            "sedes", 
            repoSede.findAll());
        return "sedes/sedes";
    }

    @GetMapping("/add")
    public String addForm(Model modelo) {
        modelo.addAttribute("sedes", repoSede.findAll());        
        return "sedes/add";
    }

    @PostMapping("/add")
    public String addSede(
        @ModelAttribute("sede") @NonNull Sede sede)  {
        repoSede.save(sede);
        return "redirect:/sedes";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(
            @PathVariable(name = "id") @NonNull Long id,
            Model modelo) {
        try {
            Optional<Sede> sede = repoSede.findById(id);
            if (sede.isPresent()){
                modelo.addAttribute(
                    "sede", sede.get());
                return "sedes/delete";
            } else {
                return "error";
            }

        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") @NonNull Long id) {
        try {
            repoSede.deleteById(id);    
        } catch (Exception e) {
            return "error";
        }
        
        return "redirect:/sedes";
    }

    @GetMapping("/edit/{id}")
    public String editForm(
        @PathVariable @NonNull Long id,
        Model modelo) {

            Optional<Sede> sede = 
                repoSede.findById(id);
            List<Sede> sedes = 
                repoSede.findAll();
                
            if (sede.isPresent()){
                modelo.addAttribute("sede", sede.get());
                modelo.addAttribute("sedes", sedes);
                return "sedes/edit";
            } else {
                modelo.addAttribute(
                    "mensaje", 
                    "sede no encontrada");
                return "error";
            }
            
    }




    




}
