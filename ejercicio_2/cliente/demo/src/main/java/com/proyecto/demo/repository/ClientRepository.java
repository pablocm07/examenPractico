package com.proyecto.demo.repository;

import java.io.Serializable;
import java.util.List;

import com.proyecto.demo.model.Cliente;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Cliente, Serializable> {
  @RestResource(path = "cliente", rel = "clienteID")
  public List<Cliente> findByClienteID(@Param("clienteID") int clienteID, Pageable pageable);

}
