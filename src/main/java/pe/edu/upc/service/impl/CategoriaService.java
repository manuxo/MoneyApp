package pe.edu.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.dao.ICategoriaDAO;
import pe.edu.upc.model.entities.Categoria;
import pe.edu.upc.service.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService{

	@Autowired
	private ICategoriaDAO categoriaRepo;

	@Override
	@Transactional(readOnly=true)
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return categoriaRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Categoria findById(Long id) {
		// TODO Auto-generated method stub
		return categoriaRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Categoria entity) {
		// TODO Auto-generated method stub
		categoriaRepo.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		categoriaRepo.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Categoria entity) {
		// TODO Auto-generated method stub
		categoriaRepo.delete(entity);
	}
	
	
}
