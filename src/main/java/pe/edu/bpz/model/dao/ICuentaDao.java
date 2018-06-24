package pe.edu.bpz.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.bpz.model.entity.Cuenta;


@Repository
public interface ICuentaDao extends JpaRepository<Cuenta, Long> {

}
