package com.geslaw.appgeslaw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geslaw.appgeslaw.model.ObligadoCumplimiento;
import com.geslaw.appgeslaw.repo.RepoObligadoCumplimiento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/obligadocumplimientos")
public class ControllerObligadoCumplimiento {
    @Autowired
    private RepoObligadoCumplimiento repoObligadoCumplimiento;

    @GetMapping("")
    public String findAll(Model modelo) {
        modelo.addAttribute("obligadocumplimientos", repoObligadoCumplimiento.findAll());
        return "obligadocumplimientos/obligadocumplimientos";
    }
    
    @GetMapping("/add")
    public String addForm(Model modelo){
        modelo.addAttribute("obligadocumplimientos", repoObligadoCumplimiento.findAll());
        return "obligadocumplimientos/add";
    }


    @PostMapping("/add")
    public String addFactura(@ModelAttribute("obligadocumplimientos") 
    @NonNull ObligadoCumplimiento obligadoCumplimiento)
    {
        repoObligadoCumplimiento.save(obligadoCumplimiento);
        return "redirect:/obligadocumplimientos";
    }


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
            modelo.addAttribute("obligadocumplimiento", obligadoCumplimiento.get());
            modelo.addAttribute("obligadocumplimientos", obligadoCumplimientos);
            return "obligadocumplimientos/edit";
        }else{
            modelo.addAttribute("mensaje", "obligadoCumplimiento no encontrado");
            return "error";
        }
    }
    
    
}
