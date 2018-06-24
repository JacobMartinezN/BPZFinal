package pe.edu.bpz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.bpz.model.entity.Factura;
import pe.edu.bpz.service.IFacturaService;


@Controller
@SessionAttributes("pago")
@RequestMapping(value ="/pago")
public class PagoController {

	
	@Autowired
	private IFacturaService fService;
	
	@GetMapping(value = "/listar")
	public String listar(Model model){
		model.addAttribute("titulo", "Listado de Facturas sin Pagar");
		model.addAttribute("facturas", fService.findByEstado());
		return "/pago/listar";	
	}
	
	@PostMapping("/pagar")
	public String pagar(Model model,@RequestParam("idfacturas") List<String>ids) {
		
		
		for (int i = 0; i < ids.size(); i++) {
			
			fService.updateEstado(Long.parseLong(ids.get(i)));
		}
		return "redirect:/pago/listar";
	}
}
