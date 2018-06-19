package pe.edu.bpz.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.bpz.model.entity.Banco;

@Repository
public interface IBancoDao extends JpaRepository<Banco, Long> {

}
