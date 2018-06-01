package pe.edu.upc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.model.entities.PresupuestoMensual;
import pe.edu.upc.service.IPersonaService;
import pe.edu.upc.service.IPresupuestoMensualService;
import pe.edu.upc.util.ComboBuilder;
import pe.edu.upc.viewmodel.PresupuestoViewModel;

@Controller
@RequestMapping(value="/presupuesto")
public class PresupuestoMensualController {

	@Autowired
	private IPresupuestoMensualService presupuestoMensualService;
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping(value="/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo","Listado de presupuestos");
		model.addAttribute("presupuestos",presupuestoMensualService.findAll());
		return "presupuesto/listar";
	}
	
	@GetMapping(value="/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("titulo","Nuevo presupuesto");
		model.addAttribute("presupuestoViewModel", new PresupuestoViewModel());
		model.addAttribute("personas",personaService.findAll());
		model.addAttribute("meses",ComboBuilder.meses());
		return "presupuesto/nuevo";
	}
	
	@PostMapping(value="/nuevo")
	public String guardar(Model model, PresupuestoViewModel presupuestoViewModel) {
		
		PresupuestoMensual presupuesto = presupuestoViewModel.getPresupuesto();
		presupuesto.setPersona(presupuestoViewModel.getPersona());
		presupuesto.setCostoPrevistoTotal(0);
		presupuesto.setCostoRealTotal(0);
		presupuesto.setDiferenciaTotal(0);
		presupuesto.setSaldoPrevisto(0);
		presupuesto.setSaldoReal(0);
		presupuestoMensualService.save(presupuesto);
		return "redirect:/presupuesto/listar";
	}
}
