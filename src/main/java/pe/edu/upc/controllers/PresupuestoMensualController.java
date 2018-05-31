package pe.edu.upc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.service.IPresupuestoMensualService;

@Controller
@RequestMapping(value="/presupuesto")
public class PresupuestoMensualController {

	@Autowired
	private IPresupuestoMensualService presupuestoMensualService;
	
	@GetMapping(value="/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo","Listado de presupuestos");
		model.addAttribute("presupuestos",presupuestoMensualService.findAll());
		return "presupuesto/listar";
	}
}
