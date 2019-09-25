package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

@Table(name="EMPLEADO")
@Entity
public class Empleado implements Serializable {
	public Empleado() {
		
	}
	
	public Empleado(long id, String nombre, String apellido1, String apellido2, String cargo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.cargo = cargo;
	}

	@GeneratedValue
	@Id
	@Column(name="ID_EMPLEADO")
	private long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="APELLIDO1")
	private String apellido1;
	
	@Column(name="APELLIDO2")
	private String apellido2;
	
	@Column(name="CARGO")
	private String cargo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
