package pe.edu.upc.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.entities.Categoria;

@Repository
public interface ICategoriaDAO extends JpaRepository<Categoria, Long>{
}
