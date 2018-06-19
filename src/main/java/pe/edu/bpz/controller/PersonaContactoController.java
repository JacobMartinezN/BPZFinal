package pe.edu.bpz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import pe.edu.bpz.service.IPersonaContactoService;

@Controller
@SessionAttributes("persona")
@RequestMapping(value="persona")
public class PersonaContactoController {
	@Autowired
	private IPersonaContactoService pCService;
	
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model){
		model.addAttribute("titulo", "Listado de personas");
		model.addAttribute("personas", pCService.findAll());
		return "listarPersonaContacto";	
	}
	

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
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {

		PersonaContacto persona = new PersonaContacto();
		persona = pCService.findById(id);
		model.addAttribute("persona", persona);
		model.addAttribute("titulo", "Editar");
		return "editarPersonaContacto";
	}
	@PostMapping(value="/editar")
	public String guardar(@Valid PersonaContacto persona, BindingResult result,Model model, RedirectAttributes flash,
			SessionStatus status) {
		if(result.hasErrors()) {
			return "redirect:/persona/listar";
		}
		
		
				
		pCService.save(persona);
		
		status.setComplete();
		
		return "redirect:/persona/listar";
	}
}
