package pe.edu.bpz.service;

import java.util.List;

import pe.edu.bpz.model.entity.Empleado;

public interface IEmpleadoService {

	public List<Empleado> finAll();
	
	public void save(Empleado empleado);
}
