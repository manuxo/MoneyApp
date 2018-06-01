package pe.edu.upc.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.entities.DetalleGasto;

@Repository
public interface IDetalleGastoDAO extends JpaRepository<DetalleGasto, Long>{

	@Query("SELECT d FROM DetalleGasto d WHERE d.gasto.id=:id")
	public List<DetalleGasto> findByIdGasto(@Param("id") Long id);
}
