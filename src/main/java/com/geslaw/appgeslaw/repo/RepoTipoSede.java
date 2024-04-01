package com.geslaw.appgeslaw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geslaw.appgeslaw.model.TipoSede;
/*
 * Lo he puesto como Long porque he puesto que el id va a ser de tipo Long
 */
public interface RepoTipoSede extends JpaRepository<TipoSede,Long>{
    
}
