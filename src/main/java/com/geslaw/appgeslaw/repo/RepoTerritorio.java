package com.geslaw.appgeslaw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geslaw.appgeslaw.model.Territorio;


/*
 * Interfaz para manejar lo que necesitemos de la clase entidad,
 * JpaRepository<Entidad,Long>  <-- es Long porque yo lo he definido en mi clase entidad como tipo Long
 */
public interface RepoTerritorio  extends JpaRepository<Territorio,Long>{
    
}
