package pe.edu.bpz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.bpz.model.dao.ICargoDao;
import pe.edu.bpz.model.entity.Cargo;

@Service
public class CargoService implements ICargoService{

	@Autowired
	private ICargoDao cargoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cargo> findAll() {
		
		return cargoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cargo cargo) {
		cargoDao.save(cargo);
		
	}

}
