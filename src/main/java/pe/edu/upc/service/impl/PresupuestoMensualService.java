package pe.edu.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.dao.IPresupuestoMensualDAO;
import pe.edu.upc.model.entities.PresupuestoMensual;
import pe.edu.upc.service.IPresupuestoMensualService;

@Service
public class PresupuestoMensualService implements IPresupuestoMensualService{

	@Autowired
	private IPresupuestoMensualDAO presupuestoMensualRepo;

	@Override
	@Transactional(readOnly=true)
	public List<PresupuestoMensual> findAll() {
		// TODO Auto-generated method stub
		return presupuestoMensualRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public PresupuestoMensual findById(Long id) {
		// TODO Auto-generated method stub
		return presupuestoMensualRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(PresupuestoMensual entity) {
		// TODO Auto-generated method stub
		entity.setCostoPrevistoTotal(0);
		entity.setCostoRealTotal(0);
		entity.setDiferenciaTotal(0);
		entity.setSaldoPrevisto(0);
		entity.setSaldoReal(0);
		presupuestoMensualRepo.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		presupuestoMensualRepo.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(PresupuestoMensual entity) {
		// TODO Auto-generated method stub
		presupuestoMensualRepo.delete(entity);
	}
	
	
}
