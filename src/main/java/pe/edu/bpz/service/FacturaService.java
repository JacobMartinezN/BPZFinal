package pe.edu.bpz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.bpz.model.dao.IFacturaDao;
import pe.edu.bpz.model.entity.Factura;

@Service
public class FacturaService implements IFacturaService{

	@Autowired
	private IFacturaDao facturaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Factura> findAll() {
		
		return facturaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Factura factura) {
		facturaDao.save(factura);
		
	}

	@Override
	@Transactional
	public Factura findbyId(Long id) {
		// TODO Auto-generated method stub
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Factura> findByEstado() {
		// TODO Auto-generated method stub
		return facturaDao.findByEstado();
	}

	@Override
	@Transactional
	@Modifying
	public void updateEstado(Long id) {
		// TODO Auto-generated method stub
		facturaDao.updateEstado(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Factura> findByEstado2() {
		// TODO Auto-generated method stub
		return facturaDao.findByEstado2();
	}

	

}
