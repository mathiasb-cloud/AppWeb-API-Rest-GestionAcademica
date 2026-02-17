package cibertec.pe.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblCurso")
public class Curso {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nroCurso;
	private String nomCurso;
	private String ciclo;
	private Integer codDocente;  
	
	public Curso() {
	}
	
	public Curso(int nroCurso, String nomCurso, String ciclo, Integer codDocente) {
		this.nroCurso = nroCurso;
		this.nomCurso = nomCurso;
		this.ciclo = ciclo;
		this.codDocente = codDocente;
	}
	
	public Curso(String nomCurso, String ciclo) {
		this.nomCurso = nomCurso;
		this.ciclo = ciclo;
	}
	
	public int getNroCurso() {
		return nroCurso;
	}
	
	public void setNroCurso(int nroCurso) {
		this.nroCurso = nroCurso;
	}
	
	public String getNomCurso() {
		return nomCurso;
	}
	
	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}
	
	public String getCiclo() {
		return ciclo;
	}
	
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	
	public Integer getCodDocente() {
		return codDocente;
	}
	
	public void setCodDocente(Integer codDocente) {
		this.codDocente = codDocente;
	}	
}