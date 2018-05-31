package pe.edu.upc.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.entities.Gasto;

@Repository
public interface IGastoDAO extends JpaRepository<Gasto, Long>{

}
