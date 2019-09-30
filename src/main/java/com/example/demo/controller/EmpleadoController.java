package com.example.demo.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Empleado;
import com.example.demo.model.MEmpleado;
import com.example.demo.service.EmpleadoService;

@RestController
@RequestMapping("/v1")
public class EmpleadoController {
	
	@Autowired
	@Qualifier("servicio")
	EmpleadoService service;
	
	@PostMapping("/empleado")
	public boolean addEmpleado(@RequestBody @Valid Empleado empleado) {
		return service.add(empleado);
	}
	
	@PutMapping("/empleado")
	public boolean updateEmpleado(@RequestBody @Valid Empleado empleado) {
		return service.update(empleado);
	}
	
	@DeleteMapping("/empleado/{id}/{nombre}")
	public boolean deleteEmpleado(@PathVariable("id") long id, @PathVariable("nombre") String nombre) {
		return service.delete(nombre, id);
	}
	
	@GetMapping(value="/empleado")
	public List<MEmpleado> GetEmpleado(Pageable pageable){
		return service.obtenerPorPaginacion(pageable);
	}
}
