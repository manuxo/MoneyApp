package pe.edu.upc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="gasto")
public class Gasto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="costo_previsto")
	private double costoPrevisto;
	
	@NotNull
	@Column(name="costo_real")
	private double costoReal;
	
	@NotNull
	private double diferencia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Categoria categoria;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private PresupuestoMensual presupuesto;

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="gasto")
	@Fetch(value=FetchMode.SUBSELECT)
	private List<DetalleGasto> detalles;
	
	//TODO: getters-setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCostoPrevisto() {
		return costoPrevisto;
	}

	public void setCostoPrevisto(double costoPrevisto) {
		this.costoPrevisto = costoPrevisto;
	}

	public double getCostoReal() {
		return costoReal;
	}

	public void setCostoReal(double costoReal) {
		this.costoReal = costoReal;
	}

	public double getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(double diferencia) {
		this.diferencia = diferencia;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public PresupuestoMensual getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(PresupuestoMensual presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
}//:~
