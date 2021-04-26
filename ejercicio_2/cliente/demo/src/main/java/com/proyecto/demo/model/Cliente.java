package com.proyecto.demo.model;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "client")
public class Cliente implements Serializable {
  @Id
  private int clienteID;
  @Indexed(unique = true)
  private String nombreUsuario;
  private String contrasenia;
  private String nombre;
  private String apellidos;
  @Indexed(unique = true)
  private String correoElectronico;
  private int edad;
  private double estatura;
  private double peso;
  private double IMC;
  private double GEB;
  private double ETA;
  private Date fechaCreacion;
  private Date fechaActualizacion;

  public Cliente() {
    super();
  }

  public Cliente(String nombreUsuario, String contrasenia, String nombre, String apellidos, String correoElectronico,
      int edad, double estatura, double peso, double IMC, double GEB, double ETA, Date fechaCreacion,
      Date fechaActualizacion) {
    super();
    this.nombreUsuario = nombreUsuario;
    this.contrasenia = contrasenia;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.correoElectronico = correoElectronico;
    this.edad = edad;
    this.estatura = estatura;
    this.peso = peso;
    this.IMC = IMC;
    this.GEB = GEB;
    this.ETA = ETA;
    this.fechaCreacion = fechaCreacion;
    this.fechaActualizacion = fechaActualizacion;
  }

  public int getClienteID() {
    return this.clienteID;
  }

  public void setClienteID(int clienteID) {
    this.clienteID = clienteID;
  }

  public String getNombreUsuario() {
    return this.nombreUsuario;
  }

  public void setNombreUsuario(String nombreUsuario) {
    this.nombreUsuario = nombreUsuario;
  }

  public String getContrasenia() {
    return this.contrasenia;
  }

  public void setContrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return this.apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getCorreoElectronico() {
    return this.correoElectronico;
  }

  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  public int getEdad() {
    return this.edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public double getEstatura() {
    return this.estatura;
  }

  public void setEstatura(double estatura) {
    this.estatura = estatura;
  }

  public double getPeso() {
    return this.peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public double getIMC() {
    return this.IMC;
  }

  public void setIMC(double IMC) {
    this.IMC = IMC;
  }

  public double getGEB() {
    return this.GEB;
  }

  public void setGEB(double GEB) {
    this.GEB = GEB;
  }

  public double getETA() {
    return this.ETA;
  }

  public void setETA(double ETA) {
    this.ETA = ETA;
  }

  public Date getFechaCreacion() {
    return this.fechaCreacion;
  }

  public void setFechaCreacion(Date fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public Date getFechaActualizacion() {
    return this.fechaActualizacion;
  }

  public void setFechaActualizacion(Date fechaActualizacion) {
    this.fechaActualizacion = fechaActualizacion;
  }

}