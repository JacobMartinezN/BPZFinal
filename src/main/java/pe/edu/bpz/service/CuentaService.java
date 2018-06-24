package pe.edu.bpz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.bpz.model.dao.ICuentaDao;
import pe.edu.bpz.model.entity.Cuenta;

@Service
public class CuentaService implements ICuentaService {

	@Autowired
	private ICuentaDao cuentaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> findAll() {
		
		return cuentaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cuenta cuenta) {
		cuentaDao.save(cuenta);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cuenta findById(Long id) {
		// TODO Auto-generated method stub
		return cuentaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		cuentaDao.deleteById(id);
	}

}
