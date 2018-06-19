package pe.edu.bpz.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.bpz.model.dao.IBancoDao;
import pe.edu.bpz.model.entity.Banco;

@Service
public class BancoService implements IBancoService{

	@Autowired
	private IBancoDao bancoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Banco> findAll() {
		
		return bancoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Banco banco) {
		bancoDao.save(banco);
	}

	
	
}
