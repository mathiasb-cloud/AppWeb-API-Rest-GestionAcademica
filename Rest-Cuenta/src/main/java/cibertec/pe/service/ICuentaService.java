package cibertec.pe.service;
import java.util.List;
import java.util.Optional;
import cibertec.pe.model.Cuenta;

public interface ICuentaService {
	
	public List<Cuenta> listarCuentas();
	public Cuenta crearCuenta(Cuenta cuenta);
	public Optional<Cuenta> buscarCuenta(String codUsuario);
	public Cuenta buscarCuentaPorCodAlumno(int codAlumno);
	public String editarCuenta(String codUsuario, Cuenta cuenta);
	public void eliminarCuenta(String codUsuario);
	public String validarLogin(String codUsuario, String contrasena);
	public void eliminarCuentaPorAlumno(int codAlumno);
}