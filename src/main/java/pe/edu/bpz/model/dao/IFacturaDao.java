package pe.edu.bpz.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.bpz.model.entity.Factura;

@Repository
public interface IFacturaDao extends JpaRepository<Factura, Long> {
	
	@Query("select f from Factura f where f.estado like 'NoPagado'")
	public List<Factura> findByEstado();

}
