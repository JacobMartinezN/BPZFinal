package pe.edu.bpz.service;

import java.util.List;

import pe.edu.bpz.model.entity.Proveedor;



public interface IProveedorService {

	public List<Proveedor> findAll();
	
	public void save(Proveedor proovedor);
	
	public Proveedor findbyId(Long id);
	
	public void eliminarPorId(Long id);
}
