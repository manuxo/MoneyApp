package pe.edu.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.dao.IGastoDAO;
import pe.edu.upc.model.entities.Gasto;
import pe.edu.upc.service.IGastoService;

@Service
public class GastoService implements IGastoService{

	@Autowired
	private IGastoDAO gastoRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Gasto> findAll() {
		// TODO Auto-generated method stub
		return gastoRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Gasto findById(Long id) {
		// TODO Auto-generated method stub
		return gastoRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Gasto entity) {
		// TODO Auto-generated method stub
		gastoRepo.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		gastoRepo.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Gasto entity) {
		// TODO Auto-generated method stub
		gastoRepo.delete(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Gasto> findByIdPresupuesto(Long id) {
		// TODO Auto-generated method stub
		return gastoRepo.findByIdPresupuesto(id);
	}
	
}
