package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.converter.Convertidor;
import com.example.demo.entity.Empleado;
import com.example.demo.model.MEmpleado;
import com.example.demo.repository.EmpleadoRepository;

@Service("servicio")
public class EmpleadoService {
	@Autowired
	@Qualifier("repositorio")
	private EmpleadoRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	public boolean add(Empleado empleado) {
		try {
			repositorio.save(empleado);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean update(Empleado empleado) {
		try {
			repositorio.save(empleado);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean delete(String nombre, long id) {
		try {
			Empleado empleado = repositorio.findByNombreAndId(nombre, id);
			
			repositorio.delete(empleado);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public List<MEmpleado> Obtener(){		
		return convertidor.convertirLista(repositorio.findAll());
	}
	
	public MEmpleado obtenerPorNombreCargo(String nombre, String cargo) {
		return new MEmpleado(repositorio.findByNombreAndCargo(nombre, cargo));
	}
	
	public List<MEmpleado> obtenerCargo(String cargo){
		return convertidor.convertirLista(repositorio.findByCargo(cargo));
	}
}
