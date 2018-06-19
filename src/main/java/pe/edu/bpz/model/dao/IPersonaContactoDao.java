package pe.edu.bpz.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.bpz.model.entity.PersonaContacto;

@Repository
public interface IPersonaContactoDao extends JpaRepository<PersonaContacto,Long> {
	
	@Query("SELECT p from PersonaContacto p where p.dni=?1")
	public PersonaContacto findByDni(Long term);
}
