package com.geslaw.appgeslaw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geslaw.appgeslaw.model.TipoUsuario;

public interface RepoTipoUsuario extends JpaRepository<TipoUsuario,Long>{
    
}
