package cibertec.pe.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblCuenta")
public class Cuenta {
	
	@Id
	private String codUsuario;
	private String correo;
	private String contrasena;
	private int codAlumno;
	
	public Cuenta() {
	}
	
	public Cuenta(String codUsuario, String correo, String contrasena, int codAlumno) {
		this.codUsuario = codUsuario;
		this.correo = correo;
		this.contrasena = contrasena;
		this.codAlumno = codAlumno;
	}
	
	public String getCodUsuario() {
		return codUsuario;
	}
	
	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public int getCodAlumno() {
		return codAlumno;
	}
	
	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
}