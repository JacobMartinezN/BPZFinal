package pe.edu.bpz.service;

import java.util.List;



import pe.edu.bpz.model.entity.Factura;

public interface IFacturaService {

	public List<Factura> findAll();
	
	public void save(Factura factura);
	
    public Factura findbyId(Long id);
    
    public List<Factura> findByEstado();
    
    public void updateEstado(Long id);
    
	public List<Factura> findByEstado2();
}
