package pe.edu.bpz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.bpz.model.dao.IPersonaContactoDao;
import pe.edu.bpz.model.entity.PersonaContacto;

@Service
public class PersonaContactoService implements IPersonaContactoService{

	
	@Autowired
	private IPersonaContactoDao personacontactoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PersonaContacto> findAll() {
		
		return personacontactoDao.findAll();
	}

	@Override
	@Transactional
	public void save(PersonaContacto personaContacto) {
		personacontactoDao.save(personaContacto);
	}

	@Override
	@Transactional(readOnly = true)
	public PersonaContacto findByDni(Long term) {
		// TODO Auto-generated method stub
		return personacontactoDao.findByDni(term);
	}

	@Override
	@Transactional(readOnly = true)
	public PersonaContacto findById(Long term) {
		// TODO Auto-generated method stub
		return personacontactoDao.findById(term).orElse(null);
	}

	@Override
	@Transactional
	public void eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		personacontactoDao.deleteById(id);
	}


	
	
	
}
