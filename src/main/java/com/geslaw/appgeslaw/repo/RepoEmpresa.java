package com.geslaw.appgeslaw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geslaw.appgeslaw.model.Empresa;

public interface RepoEmpresa extends JpaRepository<Empresa,Long>{
    
}
