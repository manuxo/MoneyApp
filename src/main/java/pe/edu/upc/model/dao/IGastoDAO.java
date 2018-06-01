package pe.edu.upc.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.entities.Gasto;

@Repository
public interface IGastoDAO extends JpaRepository<Gasto, Long>{

	@Query("SELECT g FROM Gasto g where g.presupuesto.id =:id")
	public List<Gasto> findByIdPresupuesto(@Param("id") Long id);
}
