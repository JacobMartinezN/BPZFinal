package pe.edu.bpz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.bpz.model.dao.IEmpleadoDao;
import pe.edu.bpz.model.entity.Empleado;

@Service
public class EmpleadoService implements IEmpleadoService {

	@Autowired
	private IEmpleadoDao empleadoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Empleado> finAll() {
		
		return empleadoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Empleado empleado) {
		empleadoDao.save(empleado);
		
	}

}
