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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "Proveedor")
public class Proveedor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProveedor;
	
	@NotNull
	private String razonSocial;
	
	@NotNull
	private String ruc;
	
	@NotNull
	private int cuentaBcoNacion;
	
	@NotNull
	private String tipoPersona;
	
	@OneToOne( mappedBy="proveedor", fetch = FetchType.LAZY , cascade=CascadeType.ALL)
	private PersonaContacto personaContacto;

	@OneToMany(mappedBy="proveedor",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cuenta> cuentas;
	
	@OneToMany(mappedBy="proveedor",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Factura> facturas;
	
	

	public Proveedor() {
		this.cuentas = new ArrayList<>();
		this.facturas = new ArrayList<>();
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
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

	public int getCuentaBcoNacion() {
		return cuentaBcoNacion;
	}

	public void setCuentaBcoNacion(int cuentaBcoNacion) {
		this.cuentaBcoNacion = cuentaBcoNacion;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public PersonaContacto getPersonaContacto() {
		return personaContacto;
	}

	public void setPersonaContacto(PersonaContacto personaContacto) {
		this.personaContacto = personaContacto;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}	

	
	
	
}
