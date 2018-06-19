package pe.edu.bpz.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "Banco")
public class Banco implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBanco;
	
	@NotNull
	private String razonSocial;
	
	@NotNull
	private  String ruc;
	

	@OneToMany(mappedBy="banco",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cuenta> cuentas;
	
	public Banco() {
		this.cuentas=new ArrayList<>();
	}


	public Long getIdBanco() {
		return idBanco;
	}


	public void setIdBanco(Long idBanco) {
		this.idBanco = idBanco;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getRuc() {
		return ruc;
	}


	public void setRuc(String ruc) {
		this.ruc = ruc;
	}


	public List<Cuenta> getCuentas() {
		return cuentas;
	}


	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	
	
	
	
	
}
