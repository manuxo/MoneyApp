package pe.edu.upc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.model.entities.DetalleGasto;
import pe.edu.upc.service.IDetalleGastoService;
import pe.edu.upc.service.IGastoService;

@Controller
@RequestMapping(value="/detallegasto")
public class DetalleGastoController {

	
	@Autowired
	private IGastoService gastoService;
	
	@Autowired
	private IDetalleGastoService detalleGastoService;
	
	@GetMapping(value="/listar/{idGasto}")
	public String listar(Model model,@PathVariable Long idGasto) {
		model.addAttribute("titulo","Detalles del gasto");
		model.addAttribute("detalles",detalleGastoService.findByIdGasto(idGasto));
		model.addAttribute("gasto",gastoService.findById(idGasto));
		return "detallegasto/listar";
	}
	
	
	@GetMapping(value="/nuevo/{idGasto}")
	public String nuevo(Model model, @PathVariable Long idGasto) {
		model.addAttribute("titulo", "Nuevo detalle de gasto");
		model.addAttribute("detalleGasto", new DetalleGasto());
		model.addAttribute("idGasto",idGasto);
		return "detallegasto/nuevo";
	}
	
	@PostMapping(value="/nuevo/{idGasto}")
	public String guardar(Model model, DetalleGasto detalleGasto, @PathVariable Long idGasto) {
		detalleGasto.setGasto(gastoService.findById(idGasto));
		detalleGastoService.save(detalleGasto);
		return "redirect:/detallegasto/listar/" + detalleGasto.getGasto().getId();
	}
}
