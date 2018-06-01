package pe.edu.upc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.model.entities.Gasto;
import pe.edu.upc.service.ICategoriaService;
import pe.edu.upc.service.IGastoService;
import pe.edu.upc.service.IPresupuestoMensualService;
import pe.edu.upc.viewmodel.GastoViewModel;

@Controller
@RequestMapping(value="/gasto")
public class GastoController {

	@Autowired
	private IGastoService gastoService;
	
	@Autowired
	private IPresupuestoMensualService presupuestoMensualService;
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@GetMapping(value="/listar/{idPresupuesto}")
	public String listar(Model model, @PathVariable Long idPresupuesto) {
		model.addAttribute("titulo","Gastos - presupuesto #" + idPresupuesto);
		model.addAttribute("presupuesto",presupuestoMensualService.findById(idPresupuesto));
		model.addAttribute("gastos",gastoService.findByIdPresupuesto(idPresupuesto));
		return "gasto/listar";
	}
	
	@GetMapping(value="/nuevo/{idPresupuesto}")
	public String nuevo(Model model, @PathVariable Long idPresupuesto) {
		model.addAttribute("Nuevo gasto - Presupuesto #" + idPresupuesto);
		GastoViewModel gastoViewModel = new GastoViewModel();
		model.addAttribute("gastoViewModel", gastoViewModel);
		model.addAttribute("categorias",categoriaService.findAll());
		model.addAttribute("idPresupuesto",idPresupuesto);
		return "gasto/nuevo";
	}
	
	@PostMapping(value="/nuevo/{idPresupuesto}")
	public String guardar(Model model, GastoViewModel gastoViewModel, @PathVariable Long idPresupuesto) {
		Gasto gasto = new Gasto();
		gasto.setCategoria(gastoViewModel.getCategoria());
		gasto.setPresupuesto(presupuestoMensualService.findById(idPresupuesto));
		gasto.setCostoPrevisto(0);
		gasto.setCostoReal(0);
		gasto.setDiferencia(0);
		System.out.print(gasto.getPresupuesto().getId());
		gastoService.save(gasto);
		return "redirect:/gasto/listar/" + gasto.getPresupuesto().getId();
	}
}
