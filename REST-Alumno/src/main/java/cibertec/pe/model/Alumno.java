package cibertec.pe.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codAlumno;
	private String nomAlumno;
	private String apeAlumno;
	private String emaAlumno;
	
	public Alumno() {
	}
	
	public Alumno(String nomAlumno, String apeAlumno, String emaAlumno) {
		this.nomAlumno = nomAlumno;
		this.apeAlumno = apeAlumno;
		this.emaAlumno = emaAlumno;
	}
	
	public int getCodAlumno() {
		return codAlumno;
	}
	
	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	
	public String getNomAlumno() {
		return nomAlumno;
	}
	
	public void setNomAlumno(String nomAlumno) {
		this.nomAlumno = nomAlumno;
	}
	
	public String getApeAlumno() {
		return apeAlumno;
	}
	
	public void setApeAlumno(String apeAlumno) {
		this.apeAlumno = apeAlumno;
	}
	
	public String getEmaAlumno() {
		return emaAlumno;
	}
	
	public void setEmaAlumno(String emaAlumno) {
		this.emaAlumno = emaAlumno;
	}
}