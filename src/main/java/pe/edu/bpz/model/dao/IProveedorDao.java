package pe.edu.bpz.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import pe.edu.bpz.model.entity.Proveedor;

@Repository
public interface IProveedorDao extends JpaRepository <Proveedor,Long>{
	
}
