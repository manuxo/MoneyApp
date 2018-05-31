package pe.edu.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.dao.IDetalleGastoDAO;
import pe.edu.upc.model.entities.DetalleGasto;
import pe.edu.upc.service.IDetalleGastoService;

@Service
public class DetalleGastoService implements IDetalleGastoService{

	@Autowired
	private IDetalleGastoDAO detalleGastoRepo;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<DetalleGasto> findAll() {
		// TODO Auto-generated method stub
		return detalleGastoRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public DetalleGasto findById(Long id) {
		// TODO Auto-generated method stub
		return detalleGastoRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(DetalleGasto entity) {
		// TODO Auto-generated method stub
		detalleGastoRepo.save(entity)
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		detalleGastoRepo.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(DetalleGasto entity) {
		// TODO Auto-generated method stub
		detalleGastoRepo.delete(entity);
	}

	
}
