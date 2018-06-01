package pe.edu.upc.viewmodel;

import pe.edu.upc.model.entities.Categoria;
import pe.edu.upc.model.entities.Gasto;
import pe.edu.upc.model.entities.PresupuestoMensual;

public class GastoViewModel {
	private Gasto gasto;
	
	private Categoria categoria;
	
	private PresupuestoMensual presupuesto;

	//TODO:getters-setters
	
	public Gasto getGasto() {
		return gasto;
	}

	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public PresupuestoMensual getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(PresupuestoMensual presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
}//:~
