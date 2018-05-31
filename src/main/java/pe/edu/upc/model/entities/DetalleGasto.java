package pe.edu.upc.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="detalle_gasto")
public class DetalleGasto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String descripcion;
	
	@Column(name="costo_previsto",nullable=false)
	private double costoPrevisto;
	
	@Column(name="costo_real",nullable=false)
	private double costoReal;
	
	@NotNull
	private double diferencia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Gasto gasto;

	
	//TODO: getters-setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Gasto getGasto() {
		return gasto;
	}

	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
	}
	
}//:~
