package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.entities.Gasto;

public interface IGastoService extends IService<Gasto,Long>{
	public List<Gasto> findByIdPresupuesto(Long id);
}
