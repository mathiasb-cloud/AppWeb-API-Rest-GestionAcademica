package cibertec.pe.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cibertec.pe.model.Cuenta;
import cibertec.pe.repository.ICuentaRepository;

@Service
public class CuentaImplement implements ICuentaService {
	
	@Autowired
	private ICuentaRepository cuentaRepository;
	
	@Override
	public List<Cuenta> listarCuentas() {
		return cuentaRepository.findAll();
	}
	
	@Override
	public Cuenta crearCuenta(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}
	
	@Override
	public Optional<Cuenta> buscarCuenta(String codUsuario) {
		return cuentaRepository.findById(codUsuario);
	}
	
	@Override
	public Cuenta buscarCuentaPorCodAlumno(int codAlumno) {
		return cuentaRepository.findByCodAlumno(codAlumno);
	}
	
	@Override
	public String editarCuenta(String codUsuario, Cuenta cuenta) {
		Cuenta cta = cuentaRepository.findById(codUsuario).orElse(null);
		if(cta != null) {
			cta.setCorreo(cuenta.getCorreo());
			cta.setContrasena(cuenta.getContrasena());
			cuentaRepository.save(cta);
			return "Cuenta actualizada";
		} else {
			return "Error: Cuenta no encontrada";
		}
	}
	
	@Override
	public void eliminarCuenta(String codUsuario) {
		cuentaRepository.deleteById(codUsuario);	
	}
	
	@Override
	public String validarLogin(String codUsuario, String contrasena) {
		Cuenta cuenta = cuentaRepository.findByCodUsuarioAndContrasena(codUsuario, contrasena);
		if(cuenta != null) {
			return "Login exitoso";
		} else {
			return "Usuario o contraseña incorrectos";
		}
	}
	
	
	@Override
	public void eliminarCuentaPorAlumno(int codAlumno) {
		Cuenta cuenta = cuentaRepository.findByCodAlumno(codAlumno);
		if(cuenta != null) {
			cuentaRepository.delete(cuenta);
		}
	}
}