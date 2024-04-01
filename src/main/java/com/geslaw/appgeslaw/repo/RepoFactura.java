package com.geslaw.appgeslaw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geslaw.appgeslaw.model.Factura;

public interface RepoFactura extends JpaRepository<Factura,Long>{
    
}
