package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.entities.DetalleGasto;

public interface IDetalleGastoService extends IService<DetalleGasto,Long>{
	public List<DetalleGasto> findByIdGasto(Long id);
}
