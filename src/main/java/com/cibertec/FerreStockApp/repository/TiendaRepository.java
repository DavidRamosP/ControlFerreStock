package com.cibertec.FerreStockApp.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.FerreStockApp.model.Tienda;

@Repository
public interface TiendaRepository extends CrudRepository<Tienda, Integer>, PagingAndSortingRepository<Tienda, Integer>{

}
