package com.cibertec.FerreStockApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.FerreStockApp.model.TipoUnidad;


@Repository
public interface TipoUnidadRepository extends JpaRepository<TipoUnidad, Integer> {

}
