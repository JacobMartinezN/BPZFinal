package pe.edu.bpz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class LandingController {

	@GetMapping(value = "/landing")
	public String landing(Model model){
		return "landing";	
	}
}
