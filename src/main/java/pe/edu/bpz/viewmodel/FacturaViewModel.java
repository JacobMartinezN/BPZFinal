package pe.edu.bpz.viewmodel;

import pe.edu.bpz.model.entity.Factura;
import pe.edu.bpz.model.entity.Proveedor;

public class FacturaViewModel {
	Factura factura;
	
	String fechaEmision;
	
	String fechaVencimiento;
	
	String fechaPeriodo;
	
	Proveedor proveedor;

	
	public FacturaViewModel() {
		this.factura = new Factura();
	}
	
	//TODO: getter-setter
	
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getFechaPeriodo() {
		return fechaPeriodo;
	}

	public void setFechaPeriodo(String fechaPeriodo) {
		this.fechaPeriodo = fechaPeriodo;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
}
