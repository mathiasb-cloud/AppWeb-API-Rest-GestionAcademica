package cibertec.pe.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codDocente;
	private String nomDocente;
	private String apeDocente;
	private String emaDocente;
	private String especialidad;
	
	public Docente() {
	}
	
	public Docente(String nomDocente, String apeDocente, String emaDocente, String especialidad) {
		this.nomDocente = nomDocente;
		this.apeDocente = apeDocente;
		this.emaDocente = emaDocente;
		this.especialidad = especialidad;
	}
	
	public int getCodDocente() {
		return codDocente;
	}
	
	public void setCodDocente(int codDocente) {
		this.codDocente = codDocente;
	}
	
	public String getNomDocente() {
		return nomDocente;
	}
	
	public void setNomDocente(String nomDocente) {
		this.nomDocente = nomDocente;
	}
	
	public String getApeDocente() {
		return apeDocente;
	}
	
	public void setApeDocente(String apeDocente) {
		this.apeDocente = apeDocente;
	}
	
	public String getEmaDocente() {
		return emaDocente;
	}
	
	public void setEmaDocente(String emaDocente) {
		this.emaDocente = emaDocente;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
}