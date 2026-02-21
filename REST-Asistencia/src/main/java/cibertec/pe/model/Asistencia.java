package cibertec.pe.model;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_asistencia")
public class Asistencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codAsistencia;
	private Integer codMatricula;
	private LocalDate fecha;
	private String estado;
	private String observaciones;
	
	public Asistencia() {
	}
	
	public Asistencia(Integer codMatricula, LocalDate fecha, String estado, String observaciones) {
		this.codMatricula = codMatricula;
		this.fecha = fecha;
		this.estado = estado;
		this.observaciones = observaciones;
	}
	
	public int getCodAsistencia() {
		return codAsistencia;
	}
	
	public void setCodAsistencia(int codAsistencia) {
		this.codAsistencia = codAsistencia;
	}
	
	public Integer getCodMatricula() {
		return codMatricula;
	}
	
	public void setCodMatricula(Integer codMatricula) {
		this.codMatricula = codMatricula;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}