package pe.edu.upc.util;

import pe.edu.upc.model.entities.DetalleGasto;
import pe.edu.upc.model.entities.Gasto;
import pe.edu.upc.model.entities.PresupuestoMensual;

public class CostosBuilder {

	public static void sumarizarGasto(DetalleGasto detalleGasto) {
		//Sumarizar detalle
		
		Gasto gasto = detalleGasto.getGasto();
		//Initial values
		double costoP = gasto.getCostoPrevisto();
		double costoR = gasto.getCostoReal();
		double dif = gasto.getDiferencia();
		
		gasto.setCostoPrevisto(costoP + detalleGasto.getCostoPrevisto());
		gasto.setCostoReal(costoR + detalleGasto.getCostoReal());
		gasto.setDiferencia(dif + detalleGasto.getDiferencia());
		//Sumarizar gasto
		PresupuestoMensual presupuesto = gasto.getPresupuesto();
		
		//Initial values
		double costoPi = presupuesto.getCostoPrevistoTotal();
		double costoRi = presupuesto.getCostoRealTotal();
		double difi = presupuesto.getDiferenciaTotal();
		double ingresos = presupuesto.getIngresos();
		
		presupuesto.setCostoPrevistoTotal(costoPi + gasto.getCostoPrevisto());
		presupuesto.setCostoRealTotal(costoRi + gasto.getCostoReal());
		presupuesto.setDiferenciaTotal(difi+gasto.getDiferencia());
		presupuesto.setSaldoPrevisto(ingresos - costoPi - gasto.getCostoPrevisto());
		presupuesto.setSaldoReal(ingresos - costoRi - gasto.getCostoReal());
	}
}
