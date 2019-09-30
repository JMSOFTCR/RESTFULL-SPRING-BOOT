package com.example.demo.service;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
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
	
	private static final Log logger = LogFactory.getLog(EmpleadoService.class);
	
	public boolean add(Empleado empleado) {
		logger.info("CREANDO EMPLEADO");
		try {
			repositorio.save(empleado);
			logger.info("EMPLEADO CREADO");	
			return true;
		}catch(Exception e) {
			
			logger.error("HUBO UN ERROR");
			return false;
		}
	}
	
	public boolean update(Empleado empleado) {
		logger.info("ACTUALIZANDO EMPLEADO");
		try {
			repositorio.save(empleado);
			logger.info("EMPLEADO ACTUALIZADO");
			return true;
		}catch(Exception e) {
			
			logger.error("HUBO UN ERROR");
			return false;
		}
	}
	
	public boolean delete(String nombre, long id) {
		logger.warn("ELIMINANDO EMPLEADO");
		try {
			Empleado empleado = repositorio.findByNombreAndId(nombre, id);
			
			repositorio.delete(empleado);
			logger.info("EMPLEADO ELIMINADO");
			return true;
		}catch(Exception e) {
			logger.error("HUBO UN ERROR");
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
	
	public List<MEmpleado> obtenerPorPaginacion(Pageable pageable){
		return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
	}
}
