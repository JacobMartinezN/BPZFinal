package pe.edu.bpz.model.entity;

import java.io.Serializable;


import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Pago")
public class Pago implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPago;
	
	@NotNull
	private double subtotalDetraccion;
	
	@NotNull
	private double subtotalPago;
	
	@NotNull
	private double TipoCambio;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_factura")
	private Factura factura;
	
	

	public Long getIdPago() {
		return idPago;
	}

	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}

	public double getSubtotalDetraccion() {
		return subtotalDetraccion;
	}

	public void setSubtotalDetraccion(double subtotalDetraccion) {
		this.subtotalDetraccion = subtotalDetraccion;
	}

	public double getSubtotalPago() {
		return subtotalPago;
	}

	public void setSubtotalPago(double subtotalPago) {
		this.subtotalPago = subtotalPago;
	}

	public double getTipoCambio() {
		return TipoCambio;
	}

	public void setTipoCambio(double tipoCambio) {
		TipoCambio = tipoCambio;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}


	
	

}
