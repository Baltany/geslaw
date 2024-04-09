package com.geslaw.appgeslaw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geslaw.appgeslaw.model.TipoUsuario;
import com.geslaw.appgeslaw.model.Usuario;

public interface RepoUsuario extends JpaRepository<Usuario,Long> {

    void save(TipoUsuario usuario);
    
}
