package pe.edu.bpz.service;

import java.util.List;


import pe.edu.bpz.model.entity.PersonaContacto;

public interface IPersonaContactoService {

	public List<PersonaContacto> findAll();
	
	public void save(PersonaContacto personaContacto);
	
	public PersonaContacto findById(Long term);
	public void eliminarPorId(Long id);
	
	public PersonaContacto findByDni(Long term);
}
