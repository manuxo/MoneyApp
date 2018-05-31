package pe.edu.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.dao.IPersonaDAO;
import pe.edu.upc.model.entities.Persona;
import pe.edu.upc.service.IPersonaService;

@Service
public class PersonaService implements IPersonaService{

	@Autowired
	private IPersonaDAO personaRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Persona findById(Long id) {
		// TODO Auto-generated method stub
		return personaRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Persona entity) {
		// TODO Auto-generated method stub
		personaRepo.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		personaRepo.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Persona entity) {
		// TODO Auto-generated method stub
		personaRepo.delete(entity);
	}

}
