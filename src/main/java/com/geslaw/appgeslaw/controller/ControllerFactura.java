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

import com.geslaw.appgeslaw.model.Factura;
import com.geslaw.appgeslaw.model.Sede;
import com.geslaw.appgeslaw.model.Usuario;
import com.geslaw.appgeslaw.repo.RepoEmpresa;
import com.geslaw.appgeslaw.repo.RepoFactura;
import com.geslaw.appgeslaw.repo.RepoObligadoCumplimiento;
import com.geslaw.appgeslaw.repo.RepoSede;
import com.geslaw.appgeslaw.repo.RepoTerritorio;
import com.geslaw.appgeslaw.repo.RepoUsuario;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/facturas")
public class ControllerFactura {
    @Autowired
    private RepoFactura repoFactura;

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
    public String findAll(Model modelo){
        modelo.addAttribute("facturas", repoFactura.findAll());
        return "facturas/facturas";
    }

    @GetMapping("/add")
    public String addForm(Model modelo) {
        List<Sede> sedes = repoSede.findAll(); // Obtener todas las sedes
        List<Usuario> usuarios = repoUsuario.findAll(); // Obtener todos los usuarios
        modelo.addAttribute("sedes", sedes);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("factura", new Factura());
        return "facturas/add";
    }

    @PostMapping("/add")
    public String addFactura(@ModelAttribute("factura") @NonNull Factura factura){
        repoFactura.save(factura);
        return "redirect:/facturas";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable(name = "id") @NonNull Long id,Model modelo ){
        try{
            Optional<Factura> factura = repoFactura.findById(id);
            if(factura.isPresent()){
                modelo.addAttribute("factura", factura.get());
                return "facturas/delete";
            } else{
                return "error";
            }
        }catch(Exception e){
            return "error";
        }
    }

    @PostMapping
    public String delete(
        @PathVariable("id") @NonNull Long id
    ){
        try{
            repoFactura.deleteById(id);
        }catch(Exception e){
            return "error";
        }

        return "redirect:/facturas";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable @NonNull Long id,
    Model modelo){
        Optional<Factura> factura = repoFactura.findById(id);
        List<Factura> facturas = repoFactura.findAll();
        List<Sede> sedes = repoSede.findAll();
        List<Usuario> usuarios = repoUsuario.findAll();
        if(factura.isPresent()){
            modelo.addAttribute("factura", factura.get());
            modelo.addAttribute("facturas", facturas);
            modelo.addAttribute("sedes", sedes);
            modelo.addAttribute("usuarios", usuarios);
            return "facturas/edit";
        }else{
            modelo.addAttribute("mensaje", "factura no encontrada");
            return "error";
        }
    }
}
