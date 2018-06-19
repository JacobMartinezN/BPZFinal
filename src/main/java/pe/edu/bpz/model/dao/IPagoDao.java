package pe.edu.bpz.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.bpz.model.entity.Pago;

@Repository
public interface IPagoDao extends JpaRepository<Pago, Long> {

}
