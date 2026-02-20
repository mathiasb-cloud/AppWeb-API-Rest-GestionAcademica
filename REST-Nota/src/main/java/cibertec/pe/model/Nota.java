package cibertec.pe.model;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_nota")
public class Nota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codNota;
	private Integer codMatricula; 
	private String tipoEvaluacion;
	private Double nota;
	private LocalDate fechaEvaluacion;
	private String observaciones;
	
	public Nota() {
	}
	
	public Nota(Integer codMatricula, String tipoEvaluacion, Double nota, LocalDate fechaEvaluacion, String observaciones) {
		this.codMatricula = codMatricula;
		this.tipoEvaluacion = tipoEvaluacion;
		this.nota = nota;
		this.fechaEvaluacion = fechaEvaluacion;
		this.observaciones = observaciones;
	}
	
	public int getCodNota() {
		return codNota;
	}
	
	public void setCodNota(int codNota) {
		this.codNota = codNota;
	}
	
	public Integer getCodMatricula() {
		return codMatricula;
	}
	
	public void setCodMatricula(Integer codMatricula) {  
		this.codMatricula = codMatricula;
	}
	
	public String getTipoEvaluacion() {
		return tipoEvaluacion;
	}
	
	public void setTipoEvaluacion(String tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}
	
	public Double getNota() {
		return nota;
	}
	
	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	public LocalDate getFechaEvaluacion() {
		return fechaEvaluacion;
	}
	
	public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
