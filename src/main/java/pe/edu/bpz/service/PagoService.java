package pe.edu.bpz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.bpz.model.dao.IPagoDao;
import pe.edu.bpz.model.entity.Pago;

@Service
public class PagoService implements IPagoService {

	@Autowired
	private IPagoDao pagoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Pago> findAll() {
		
		return pagoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Pago pago) {
		pagoDao.save(pago);
		
	}

}
