package pe.edu.bpz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.bpz.model.entity.Factura;
import pe.edu.bpz.model.entity.Pago;
import pe.edu.bpz.service.IFacturaService;
import pe.edu.bpz.service.IPagoService;
import pe.edu.bpz.service.PagoService;


@Controller
@SessionAttributes("pago")
@RequestMapping(value ="/pago")
public class PagoController {

	
	@Autowired
	private IFacturaService fService;
	
	@Autowired
	private IPagoService pService;
	
	
	@GetMapping(value = "/listar")
	public String listar(Model model){
		model.addAttribute("titulo", "Listado de Facturas sin Pagar");
		model.addAttribute("facturas", fService.findByEstado());
		model.addAttribute("facturaspag", fService.findByEstado2());
		return "/pago/listar";	
	}
	
	@Secured("ROLE_CONTADOR")
	@PostMapping("/pagar")
	public String pagar(Model model,@RequestParam("idfacturas") List<String>ids) {
		
		Factura factura=new Factura();
		List<String>codigos=new ArrayList<>();
		List<String>provs=new ArrayList<>();
		String formato="0000000000";
		Pago pago=new Pago();
		
		for (int i = 0; i < ids.size(); i++) {
			
			fService.updateEstado(Long.parseLong(ids.get(i)));
			factura=fService.findbyId(Long.parseLong(ids.get(i)));
			
			pago.setFactura(factura);
			pago.setSubtotalDetraccion(factura.getSubtotal());
			pago.setSubtotalPago(factura.getTotal());
			pago.setTipoCambio(3.25);
			
			
			String codigo="6"+factura.getProveedor().getRuc()+formato+String.valueOf(factura.getCodigoServicio())
			+ String.valueOf(factura.getProveedor().getCuentaBcoNacion())+formato+String.valueOf(factura.getTotal())
			+factura.getPeriodoDetraccion()+"01"+factura.getNumFactura();
			
			codigos.add(codigo);
			String prov;
			if(factura.getProveedor().getCuentas().size()!=0 || factura.getProveedor().getCuentas() ==null) {
			prov=factura.getProveedor().getRuc()+factura.getNumFactura()+factura.getFechaVencimiento()+factura.getTipoMoneda()
			+factura.getTotal()+factura.getProveedor().getCuentas().get(0).getTipoCuenta()+factura.getProveedor().getTipoPersona()
			+"02"+factura.getProveedor().getRuc()+factura.getProveedor().getRazonSocial();
			}else {
				prov=factura.getProveedor().getRuc()+factura.getNumFactura()+factura.getFechaVencimiento()+factura.getTipoMoneda()
				+factura.getTotal()+"01"+factura.getProveedor().getTipoPersona()
				+"02"+factura.getProveedor().getRuc()+factura.getProveedor().getRazonSocial();
			}
			provs.add(prov);
			pService.save(pago);
			
		}
		model.addAttribute("codigospro", codigos);
		model.addAttribute("codigosprov", provs);
		
		return "/pago/pagar";
	}
}
