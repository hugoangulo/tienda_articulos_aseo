package com.tienda.tienda_articulos_aseo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.tienda_articulos_aseo.model.*;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

}
