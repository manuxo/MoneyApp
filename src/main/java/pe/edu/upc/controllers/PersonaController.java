package pe.edu.upc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.model.entities.Persona;
import pe.edu.upc.service.IPersonaService;

@Controller
@RequestMapping(value="/persona")
public class PersonaController {

	@Autowired
	private IPersonaService personaService;
	
	@GetMapping(value="/registrar")
	public String registrar(Model model) {
		model.addAttribute("titulo","Registrar persona");
		model.addAttribute("persona", new Persona());
		return "persona/registrar";
	}
	
	@PostMapping(value="/registrar")
	public String guardar(Model model,@Valid Persona persona) {
		personaService.save(persona);
		return "redirect:/";
	}
}
