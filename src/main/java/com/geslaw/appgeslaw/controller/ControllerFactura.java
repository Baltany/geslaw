package com.geslaw.appgeslaw.controller;

import java.io.IOException;

import java.util.List;
import java.util.Optional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.geslaw.appgeslaw.service.ServiceFile;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;






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

    @Autowired
    private ServiceFile serviceFile;


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
    public String addFactura(@ModelAttribute("factura") @NonNull Factura factura,
                             @RequestParam("fichero") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                // Guardar el archivo adjunto en el sistema de archivos
                String originalFileName = file.getOriginalFilename();
                Path uploadPath = Paths.get("/docs/facturas", originalFileName);
                
                // Crear directorios si no existen
                Files.createDirectories(uploadPath.getParent());
                
                // Transferir el archivo al directorio de carga
                file.transferTo(uploadPath);

                // Guardar la factura en la base de datos
                repoFactura.save(factura);
    
                return "redirect:/facturas";
            } else {
                // Manejo de error si el archivo está vacío
                return "error";
            }
        } catch (IOException e) {
            // Manejo de excepciones
            return "error";
        }
    }

    // @GetMapping("/delete/{id}")
    // public String deleteForm(@PathVariable(name = "id") @NonNull Long id,Model modelo ){
    //     try{
    //         Optional<Factura> factura = repoFactura.findById(id);
    //         if(factura.isPresent()){
    //             modelo.addAttribute("factura", factura.get());
    //             return "facturas/delete";
    //         } else{
    //             return "error";
    //         }
    //     }catch(Exception e){
    //         return "error";
    //     }
    // }

    @PostMapping("/delete/{id}")
    public String deleteFactura(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            Optional<Factura> facturaOptional = repoFactura.findById(id);
    
            if (facturaOptional.isPresent()) {
                Factura factura = facturaOptional.get();
                repoFactura.delete(factura);
                redirectAttributes.addFlashAttribute("successMessage", "Factura eliminada correctamente");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Factura no encontrada");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al eliminar la factura");
        }
    
        return "redirect:/facturas"; // Redirige a la página principal de facturas
    }
    

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Factura> facturaOptional = repoFactura.findById(id);
        if (facturaOptional.isPresent()) {
            Factura factura = facturaOptional.get();
            List<Sede> sedes = repoSede.findAll(); // Obtener todas las sedes
            List<Usuario> usuarios = repoUsuario.findAll(); // Obtener todos los usuarios
            model.addAttribute("factura", factura);
            model.addAttribute("sedes", sedes);
            model.addAttribute("usuarios", usuarios);
            return "facturas/edit";
        } else {
            model.addAttribute("mensaje", "Factura no encontrada");
            return "error";
        }
    }
    
    @PostMapping("/edit/{id}")
    public String editFactura(@PathVariable Long id,
                              @ModelAttribute("factura") Factura factura,
                              BindingResult result,
                              @RequestParam("file") MultipartFile file,
                              RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "facturas/edit";
        }

        try {
            Optional<Factura> facturaExistenteOptional = repoFactura.findById(id);
            if (facturaExistenteOptional.isPresent()) {
                Factura facturaExistente = facturaExistenteOptional.get();

                // Actualizar los campos de la factura existente
                facturaExistente.setNombre(factura.getNombre());
                facturaExistente.setProveedor(factura.getProveedor());
                facturaExistente.setSede(factura.getSede());
                facturaExistente.setUsuario(factura.getUsuario());
                facturaExistente.setEstado(factura.getEstado());
                facturaExistente.setVisto(factura.getVisto());
                facturaExistente.setConcepto(factura.getConcepto());
                facturaExistente.setFechaVa(factura.getFechaVa());
                facturaExistente.setObservaciones(factura.getObservaciones());

                // Guardar el archivo adjunto si se proporciona uno nuevo
                if (!file.isEmpty()) {
                    String uniqueFileName = serviceFile.guardarFile(file);
                    facturaExistente.setFichero(uniqueFileName);
                }

                // Guardar la factura actualizada en la base de datos
                repoFactura.save(facturaExistente);

                redirectAttributes.addFlashAttribute("successMessage", "Factura actualizada correctamente");
                return "redirect:/facturas";
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Factura no encontrada");
                return "redirect:/facturas";
            }
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Error al actualizar la factura");
            return "redirect:/facturas";
        }
    }
                   
}
