package com.geslaw.appgeslaw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geslaw.appgeslaw.model.Empresa;
import com.geslaw.appgeslaw.repo.RepoEmpresa;
import com.geslaw.appgeslaw.repo.RepoSede;

import lombok.NonNull;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/* @Controller -> Controlador de mi clase Entidad,es el que maneja el crud completo y algun método mas si hiciera falta 
 * @RequestMapping -> indicamos el nombre de nuestro endpoint
*/
@Controller
@RequestMapping("/empresas")
public class ControllerEmpresa {
    @Autowired
    private RepoEmpresa repoEmpresa;

    @GetMapping("")
    public String findAll(Model modelo) {
        modelo.addAttribute(
            "empresas", 
            repoEmpresa.findAll());
        return "empresas/empresas";
    }

    @GetMapping("/add")
    public String addForm(Model modelo) {
        modelo.addAttribute("empresas", repoEmpresa.findAll());
        return "empresas/add";
    }

    @PostMapping("/add")
    public String addEmpresa(@ModelAttribute("empresa") @NonNull Empresa empresa) {
        repoEmpresa.save(empresa);        
        return "redirect:/empresas";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(
        @PathVariable(name = "id") @NonNull Long id,
        Model modelo
    ){
        try{
            Optional<Empresa> empresa = repoEmpresa.findById(id);
            if(empresa.isPresent()){
                modelo.addAttribute("empresa", empresa.get());
                return "empresas/delete";
            }else{
                return "error";
            }

        }catch(Exception e){
            return "error";
        }

    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") @NonNull Long id) {
        
        try{
            repoEmpresa.deleteById(id);
        }catch(Exception e){
            return "error";
        }

        return "redirect:/empresas";

    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable @NonNull Long id,Model modelo) {
        Optional<Empresa> empresa = repoEmpresa.findById(id);
        List<Empresa> empresas = repoEmpresa.findAll();
        
        if(empresa.isPresent()){
            modelo.addAttribute("empresa", empresa.get());
            modelo.addAttribute("empresas", empresas);
            return "empresas/edit";
        }else{
            modelo.addAttribute("mensaje", "empresa no encontrada");
            return "error";
        }
    }
    
    
    
    
}
