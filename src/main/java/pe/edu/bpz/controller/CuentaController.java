package pe.edu.bpz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import pe.edu.bpz.model.entity.Cuenta;
import pe.edu.bpz.model.entity.Proveedor;
import pe.edu.bpz.service.IBancoService;
import pe.edu.bpz.service.ICuentaService;
import pe.edu.bpz.service.IProveedorService;


@Controller
@SessionAttributes("cuenta")
@RequestMapping(value="cuenta")
public class CuentaController {
	
	@Autowired
	private ICuentaService cService;
	@Autowired
	private IBancoService bService;
	@Autowired
	private IProveedorService pService;
	
	@Secured("ROLE_CUENTAS")
	@GetMapping(value = "/crear/{id}")
	public String crear(Model model,@PathVariable(value = "id") Long id) {

		Cuenta cuenta = new Cuenta();
		Proveedor prov=pService.findbyId(id);
		cuenta.setProveedor(prov);
		model.addAttribute("cuenta", cuenta);
		model.addAttribute("titulo", "Crear Cuenta");
		model.addAttribute("bancos", bService.findAll());
		return "cuenta/crear";
	}
	
	@Secured("ROLE_CUENTAS")
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		Cuenta cuenta = cService.findById(id);

		if (cuenta != null) {
			cService.eliminarPorId(id);
			flash.addFlashAttribute("success", "cuenta eliminada con éxito!");
			return "redirect:/proveedor/detalle/"+cuenta.getProveedor().getIdProveedor().toString();
		}
		flash.addFlashAttribute("error", "La cuenta no existe en la base de datos, no se pudo eliminar!");

		return "proveedor/detalle";
	}
	
	@Secured("ROLE_CUENTAS")
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {

		Cuenta cuenta = cService.findById(id);
		model.addAttribute("cuenta", cuenta);
		model.addAttribute("titulo", "Editar Cuenta");
		model.addAttribute("bancos", bService.findAll());
		return "cuenta/crear";
	}
	
	@Secured("ROLE_CUENTAS")
	@PostMapping(value="/crear")
	public String guardar(@Valid Cuenta cuenta, BindingResult result,Model model, RedirectAttributes flash,
			SessionStatus status) {
		if(result.hasErrors()) {
			return "cuenta/crear";
		}
		
		
				
		cService.save(cuenta);
		
		status.setComplete();
		
		return "redirect:/proveedor/detalle/"+cuenta.getProveedor().getIdProveedor().toString();
	}
}
