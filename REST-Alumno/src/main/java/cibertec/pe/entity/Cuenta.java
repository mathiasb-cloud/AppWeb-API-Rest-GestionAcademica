package cibertec.pe.entity;

public class Cuenta {
	private String codUsuario;
	private String correo;
	private String contrasena;
	private Integer codAlumno;  

	public Cuenta() {
	}

	public Cuenta(String codUsuario, String correo, String contrasena, Integer codAlumno) {
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

	public Integer getCodAlumno() {  
		return codAlumno;
	}

	public void setCodAlumno(Integer codAlumno) {  
		this.codAlumno = codAlumno;
	}
}