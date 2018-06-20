package pe.edu.bpz.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Factura")
public class Factura implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private int codigoServicio;

	@NotNull
	private String numFactura;
	
	@NotNull
	private String estado;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaEmision;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaVencimiento;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date periodoDetraccion;
	
	private String descripcion;
	
	@NotNull
	private int tipoMoneda;
	
	@NotNull
	private double subtotal;
	
	@NotNull
	private double total;
	
	@NotNull
	private double porcentajeDetraccion;
	
	@OneToOne(mappedBy="factura" ,fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Pago pago;
		
	@ManyToOne(fetch = FetchType.LAZY)
	private Proveedor proveedor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(int codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(int tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getTotal() {
		 this.total=subtotal*0.82;
	     return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getPorcentajeDetraccion() {
		return porcentajeDetraccion;
	}

	public void setPorcentajeDetraccion(double porcentajeDetraccion) {
		this.porcentajeDetraccion = porcentajeDetraccion;
	}



	public Date getPeriodoDetraccion() {
		return periodoDetraccion;
	}

	public void setPeriodoDetraccion(Date periodoDetraccion) {
		this.periodoDetraccion = periodoDetraccion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
	

}
