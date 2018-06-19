package pe.edu.bpz.service;

import java.util.List;

import pe.edu.bpz.model.entity.Banco;

public interface IBancoService {

	public List<Banco> findAll();
	
	public void save(Banco banco);
}
