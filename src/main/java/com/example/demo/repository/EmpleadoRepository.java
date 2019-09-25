package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Empleado;;

@Repository("repositorio")
public interface EmpleadoRepository extends JpaRepository<Empleado, Serializable> {
	public abstract Empleado findByNombre(String nombre);
	
	public abstract List<Empleado> findByCargo(String cargo);
	
	public abstract Empleado findByNombreAndCargo(String nombre, String cargo);
}
