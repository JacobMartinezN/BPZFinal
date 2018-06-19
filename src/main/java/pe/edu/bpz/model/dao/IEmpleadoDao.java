package pe.edu.bpz.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.bpz.model.entity.Empleado;

@Repository
public interface IEmpleadoDao extends JpaRepository<Empleado, Long> {

}
