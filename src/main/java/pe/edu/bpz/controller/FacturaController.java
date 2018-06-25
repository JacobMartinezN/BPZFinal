package pe.edu.bpz.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.bpz.model.entity.Factura;
import pe.edu.bpz.model.entity.Proveedor;
import pe.edu.bpz.service.IFacturaService;
import pe.edu.bpz.service.IProveedorService;
import pe.edu.bpz.viewmodel.FacturaViewModel;
@Controller
@SessionAttributes("factura")
@RequestMapping(value="/factura")
public class FacturaController {
	@Autowired
	private IProveedorService pService;
	
	@Autowired
	private IFacturaService fService;
	

	
	
	@GetMapping(value = "/listar")
	public String listar(Model model){
		model.addAttribute("titulo", "Listado de Facturas");
		model.addAttribute("facturas", fService.findAll());
		return "/factura/listar";	
	}
	
	@Secured("ROLE_CUENTAS")
	@GetMapping(value = "/crear")
	public String crear(Model model) {
		FacturaViewModel facturaViewModel = new FacturaViewModel();
		
		model.addAttribute("facturaViewModel", facturaViewModel);
		model.addAttribute("proveedores", pService.findAll());
		model.addAttribute("titulo", "Crear Factura");
		
		return "factura/crear";
	}
	
	@Secured("ROLE_CUENTAS")
	@SuppressWarnings("deprecation")
	@PostMapping(value="/crear")
	public String guardar(@Valid FacturaViewModel facturaViewModel, BindingResult result,Model model, RedirectAttributes flash,
			SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Crear Factura");
			return "factura/crear";
		}
		
		System.out.print("\n\n\n\n"+ facturaViewModel.getFactura().getDescripcion() + "\n\n\n\n");
		
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			facturaViewModel.getFactura().setFechaEmision(formatter.parse(facturaViewModel.getFechaEmision()));
			facturaViewModel.getFactura().setFechaVencimiento(formatter.parse(facturaViewModel.getFechaVencimiento()));
			facturaViewModel.getFactura().setPeriodoDetraccion(formatter.parse(facturaViewModel.getFechaPeriodo()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(facturaViewModel.getFactura().getEstado()==null) {
			facturaViewModel.getFactura().setEstado("Por Pagar");
		}
		if (facturaViewModel.getFactura().getFechaVencimiento().before(facturaViewModel.getFactura().getFechaEmision())) {
			flash.addFlashAttribute("error", "Fecha de Vencimiento no puede ser antes que la fecha de Emision");
			return "factura/crear";
		}
		facturaViewModel.getFactura().setProveedor(facturaViewModel.getProveedor());
		
		fService.save(facturaViewModel.getFactura());
		
		status.setComplete();
		
		return "redirect:/factura/listar";
	}
	
	@Secured("ROLE_CUENTAS")
	@RequestMapping(value = "/crear/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model, @Valid FacturaViewModel facturaViewModel,
			BindingResult result, RedirectAttributes flash,	SessionStatus status) {
		model.addAttribute("proveedores", pService.findAll());
		model.addAttribute("titulo", "Editar Factura");
	
		Factura factura = fService.findbyId(id);
		factura.setId(id);
		Proveedor proveedor = new Proveedor();
		proveedor = pService.findbyId(factura.getProveedor().getIdProveedor());
		
		facturaViewModel.setFactura(factura);
		facturaViewModel.setProveedor(proveedor);
		facturaViewModel.setFechaEmision(factura.getFechaEmision().toString());
		facturaViewModel.setFechaVencimiento(factura.getFechaVencimiento().toString());
		facturaViewModel.setFechaPeriodo(factura.getPeriodoDetraccion().toString());
		
		model.addAttribute("facturaViewModel", facturaViewModel);
		
		status.setComplete();
		
		return "factura/crear";
	}
	

	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable(value="id") Long id, Model model, RedirectAttributes flash) {
		
		Factura factura= fService.findbyId(id);
		if(factura==null) {
			flash.addFlashAttribute("error", "La factura no existe");
			return "redirect:/factura/listar";
		}
		model.addAttribute("factura", factura);
		
		
		
		return "factura/detalle";
	}
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(       Date.class,     
	                         new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));   
	}

}
