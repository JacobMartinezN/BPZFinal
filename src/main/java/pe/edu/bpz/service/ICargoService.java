package pe.edu.bpz.service;

import java.util.List;

import pe.edu.bpz.model.entity.Cargo;

public interface ICargoService {

	public List<Cargo> findAll();
	
	public void save(Cargo cargo);
}
