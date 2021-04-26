package com.proyecto.demo.controller;

import java.util.List;

import com.mongodb.MongoException;
import com.proyecto.demo.model.Cliente;
import com.proyecto.demo.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

  @Autowired
  public ClientRepository clientRepository;

  @GetMapping(value = "/cliente")
  public List<Cliente> getAllClients() {
    return clientRepository.findAll();
  }

  @PostMapping(value = "/cliente")
  public String crearCliente(@RequestBody Cliente cliente) throws Exception, MongoException, DataAccessException {
    Cliente insertCliente = clientRepository.insert(cliente);
    return "Cliente creado " + insertCliente.getNombre();
  }

  @PutMapping(value = "/cliente")
  public String guardarCliente(@RequestBody Cliente cliente) {
    Cliente actualizarCliente = clientRepository.save(cliente);
    return "Cliente actualizado " + actualizarCliente.getNombre();
  }

}