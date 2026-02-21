package cibertec.pe.entity;
import java.time.LocalDate;

public class Matricula {
	private int codMatricula;
	private int codAlumno;
	private int codCurso;
	private LocalDate fechaMatricula;
	private String estado;
	
	public Matricula() {
	}
	
	public Matricula(int codMatricula, int codAlumno, int codCurso, LocalDate fechaMatricula, String estado) {
		this.codMatricula = codMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fechaMatricula = fechaMatricula;
		this.estado = estado;
	}
	
	public int getCodMatricula() {
		return codMatricula;
	}
	
	public void setCodMatricula(int codMatricula) {
		this.codMatricula = codMatricula;
	}
	
	public int getCodAlumno() {
		return codAlumno;
	}
	
	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	
	public int getCodCurso() {
		return codCurso;
	}
	
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	
	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}
	
	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
}