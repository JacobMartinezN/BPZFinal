package pe.edu.bpz.model.entity;

import java.io.Serializable;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PersonaContacto")
public class PersonaContacto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonaContacto;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private  String apellido;
	
	@NotNull
	private Long dni;
	
	@NotNull
	private Long celular;
	
	@NotNull
	@Email
	private String correo;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Long getIdPersonaContacto() {
		return idPersonaContacto;
	}

	public void setIdPersonaContacto(Long idPersonaContacto) {
		this.idPersonaContacto = idPersonaContacto;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
	
	
	
	
	
}
