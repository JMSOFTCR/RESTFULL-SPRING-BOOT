package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Empleado;
import com.example.demo.model.MEmpleado;

@Component("convertidor")
public class Convertidor {
	public List<MEmpleado> convertirLista(List<Empleado> empleados){
		List<MEmpleado> mempleados = new ArrayList<>();
		
		for(Empleado empleado : empleados) {
			mempleados.add(new MEmpleado(empleado));
		}
		
		return mempleados;
	}
}