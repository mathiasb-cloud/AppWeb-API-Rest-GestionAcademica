package cibertec.pe.model;
import cibertec.pe.entity.Cuenta;

public class AlumnoConCuentaRequest {
	private Alumno alumno;
	private Cuenta cuenta;

	public AlumnoConCuentaRequest() {
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
}