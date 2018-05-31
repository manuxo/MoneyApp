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
@Table(name="presupuesto_mensual")
public class PresupuestoMensual implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private int anio;
	
	@NotNull
	private String mes;
	
	@NotNull
	private double ingresos;
	
	@Column(name="saldo_previsto",nullable=false)
	private double saldoPrevisto;
	
	@Column(name="saldo_real",nullable=false)
	private double saldoReal;
	
	@Column(name="costo_previsto_total",nullable=false)
	private double costoPrevistoTotal;
	
	@Column(name="costo_real_total",nullable=false)
	private double costoRealTotal;
	
	@Column(name="diferencia_total",nullable=false)
	private double diferenciaTotal;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Persona persona;

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="presupuesto")
	@Fetch(value=FetchMode.SUBSELECT)
	private List<Gasto> gastos;
	
	
	//TODO: getters-setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public double getIngresos() {
		return ingresos;
	}

	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}

	public double getSaldoPrevisto() {
		return saldoPrevisto;
	}

	public void setSaldoPrevisto(double saldoPrevisto) {
		this.saldoPrevisto = saldoPrevisto;
	}

	public double getSaldoReal() {
		return saldoReal;
	}

	public void setSaldoReal(double saldoReal) {
		this.saldoReal = saldoReal;
	}

	public double getCostoPrevistoTotal() {
		return costoPrevistoTotal;
	}

	public void setCostoPrevistoTotal(double costoPrevistoTotal) {
		this.costoPrevistoTotal = costoPrevistoTotal;
	}

	public double getCostoRealTotal() {
		return costoRealTotal;
	}

	public void setCostoRealTotal(double costoRealTotal) {
		this.costoRealTotal = costoRealTotal;
	}

	public double getDiferenciaTotal() {
		return diferenciaTotal;
	}

	public void setDiferenciaTotal(double diferenciaTotal) {
		this.diferenciaTotal = diferenciaTotal;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}//:~
