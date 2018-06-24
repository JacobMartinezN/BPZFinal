package pe.edu.bpz.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.bpz.model.entity.Factura;

@Repository
public interface IFacturaDao extends JpaRepository<Factura, Long> {
	
	@Query("select f from Factura f where f.estado like 'Por Pagar'")
	public List<Factura> findByEstado();
	
	@Query("select f from Factura f where f.estado like 'Pagado'")
	public List<Factura> findByEstado2();
	
	@Modifying
	@Query("UPDATE Factura f SET f.estado = 'Pagado' WHERE f.id =?1")
	void updateEstado(Long id);

}
