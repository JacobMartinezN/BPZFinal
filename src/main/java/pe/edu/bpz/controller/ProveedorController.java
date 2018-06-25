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

import pe.edu.bpz.model.entity.Contenedor;
import pe.edu.bpz.model.entity.PersonaContacto;
import pe.edu.bpz.model.entity.Proveedor;
import pe.edu.bpz.service.ICuentaService;
import pe.edu.bpz.service.IPersonaContactoService;
import pe.edu.bpz.service.IProveedorService;



@Controller
@SessionAttributes("proveedor")
@RequestMapping("/proveedor/")
public class ProveedorController {

	@Autowired
	private IProveedorService pService;
	@Autowired
	private IPersonaContactoService pCService;
	
	
	
	
	@GetMapping(value = "/listar")
	public String listar(Model model){
		model.addAttribute("titulo", "Listado de proveedores");
		model.addAttribute("proveedores", pService.findAll());
		return "proveedor/listar";	
	}
	
	@Secured("ROLE_CUENTAS")
	@GetMapping(value = "/crear")
	public String crear(Model model) {

		Contenedor contenedor = new Contenedor();
		model.addAttribute("contenedor", contenedor);
		model.addAttribute("titulo", "Nuevo Proveedor y Persona Contacto");
		return "proveedor/crear";
	}
	@Secured("ROLE_CUENTAS")
	@PostMapping(value="/crear")
	public String guardar(@Valid Contenedor contenedor, BindingResult result,Model model, RedirectAttributes flash,
			SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Proveedor");
			return "proveedor/crear";
		}
		pCService.save(contenedor.getPersonacontacto());		
		PersonaContacto personacontacto = pCService.findByDni(contenedor.getPersonacontacto().getDni());
		
		Proveedor proveedorCompleto = contenedor.getProveedor();		
		proveedorCompleto.setPersonaContacto(personacontacto);
		personacontacto.setProveedor(proveedorCompleto);
		proveedorCompleto.setPersonaContacto(personacontacto);
		personacontacto.setProveedor(proveedorCompleto);
		
		pService.save(proveedorCompleto);
		pCService.save(personacontacto);	
		status.setComplete();
		
		return "redirect:/proveedor/listar";
	}
	
	@Secured("ROLE_CUENTAS")
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		Proveedor proveedor = pService.findbyId(id);

		if (proveedor != null) {
			pService.eliminarPorId(id);
			flash.addFlashAttribute("success", "Proveedor eliminado con éxito!");
			return "redirect:/proveedor/listar/" ;
		}
		flash.addFlashAttribute("error", "El proveedor no existe en la base de datos, no se pudo eliminar!");

		return "redirect:/proveedor/listar";
	}
	
	@Secured("ROLE_CUENTAS")
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {

		Proveedor proveedor = new Proveedor();
		proveedor = pService.findbyId(id);
		model.addAttribute("proveedor", proveedor);
		model.addAttribute("titulo", "Editar");
		return "proveedor/editar";
	}
	
	@Secured("ROLE_CUENTAS")
	@PostMapping(value="/editar")
	public String guardar(@Valid Proveedor proveedor, BindingResult result,Model model, RedirectAttributes flash,
			SessionStatus status) {
		if(result.hasErrors()) {
			return "redirect:/proveedor/listar";
		}
		
		
				
		pService.save(proveedor);
		
		status.setComplete();
		
		return "redirect:/proveedor/listar";
	}
	
	
	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable(value="id") Long id, Model model, RedirectAttributes flash) {
		
		Proveedor proveedor=pService.findbyId(id);
		if(proveedor==null) {
			flash.addFlashAttribute("error", "El proveedor no existe");
			return "redirect:/proveedor/listar";
		}
		
		model.addAttribute("proveedor", proveedor);
		model.addAttribute("nombre", proveedor.getRazonSocial());
		model.addAttribute("persona", pCService.findById(proveedor.getIdProveedor().longValue()));
		
		return "proveedor/detalle";
	}
}
