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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import pe.edu.bpz.model.entity.PersonaContacto;
import pe.edu.bpz.model.entity.Proveedor;
import pe.edu.bpz.service.IPersonaContactoService;
import pe.edu.bpz.service.IProveedorService;

@Controller
@SessionAttributes("persona")
@RequestMapping(value="persona")
public class PersonaContactoController {
	@Autowired
	private IPersonaContactoService pCService;
	private IProveedorService pService;
	
	
	@Secured("ROLE_CUENTAS")
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model){
		model.addAttribute("titulo", "Listado de personas");
		model.addAttribute("personas", pCService.findAll());
		return "listarPersonaContacto";	
	}
	
	@Secured("ROLE_CUENTAS")
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		PersonaContacto persona = pCService.findById(id);

		if (persona != null) {
			pCService.eliminarPorId(id);
			flash.addFlashAttribute("success", "Persona eliminada con éxito!");
			return "redirect:/persona/listar/" ;
		}
		flash.addFlashAttribute("error", "La persona no existe en la base de datos, no se pudo eliminar!");

		return "redirect:/persona/listar";
	}
	
	@Secured("ROLE_CUENTAS")
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {

		PersonaContacto persona = pCService.findById(id);
		model.addAttribute("persona", persona);
		model.addAttribute("titulo", "Editar Persona");
		return "persona/editar";
	}
	
	@Secured("ROLE_CUENTAS")
	@PostMapping(value="/editar")
	public String guardar(@Valid PersonaContacto persona, BindingResult result,Model model, RedirectAttributes flash,
			SessionStatus status) {
		if(result.hasErrors()) {
			return "persona/editar";
		}
		
			
		pCService.save(persona);
	
		status.setComplete();
		
		return "redirect:/proveedor/detalle/"+ persona.getIdPersonaContacto();
	}
}
