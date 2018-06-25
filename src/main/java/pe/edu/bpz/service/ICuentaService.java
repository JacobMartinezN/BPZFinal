package pe.edu.bpz.service;

import java.util.List;

import pe.edu.bpz.model.entity.Cuenta;

public interface ICuentaService {

	public List<Cuenta> findAll();
	
	public void save(Cuenta cuenta);
	
	public Cuenta findById(Long id);
	
	public void eliminarPorId(Long id);
	
	
}
