package pe.edu.bpz.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Cuenta")
public class Cuenta implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCuenta;
	
	@NotNull
	private String cuenta;
	
	@NotNull
	private  String cuentaInterbancaria;
	
	@NotNull
	private  String tipoMoneda;
	
	@NotNull
	private  String tipoCuenta;
	
	@NotNull
	private  int tipoCuentaDeposito;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Proveedor proveedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Banco banco;

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getCuentaInterbancaria() {
		return cuentaInterbancaria;
	}

	public void setCuentaInterbancaria(String cuentaInterbancaria) {
		this.cuentaInterbancaria = cuentaInterbancaria;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public int getTipoCuentaDeposito() {
		return tipoCuentaDeposito;
	}

	public void setTipoCuentaDeposito(int tipoCuentaDeposito) {
		this.tipoCuentaDeposito = tipoCuentaDeposito;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	
	

}
