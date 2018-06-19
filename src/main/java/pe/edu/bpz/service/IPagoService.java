package pe.edu.bpz.service;

import java.util.List;

import pe.edu.bpz.model.entity.Pago;

public interface IPagoService {

	public List<Pago> findAll();
	
	public void save(Pago pago);
}
