package cibertec.pe.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cibertec.pe.entity.Cuenta;
import cibertec.pe.feignclient.CuentaFeignClient;
import cibertec.pe.model.Alumno;
import cibertec.pe.repository.IAlumnoRepository;

@Service
public class AlumnoImplement implements IAlumnoService {
	
	@Autowired
	private IAlumnoRepository alumnoRepository;
	
	@Autowired
	private CuentaFeignClient cuentaFeign;
	
	@Override
	public List<Alumno> listarAlumnos() {
		return alumnoRepository.findAll();
	}
	
	@Override
	public Alumno crearAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}
	
	@Override
	public Optional<Alumno> buscarAlumno(int codigo) {
		return alumnoRepository.findById(codigo);
	}
	
	@Override
	public String editarAlumno(int codigo, Alumno alumno) {
		Alumno alum = alumnoRepository.findById(codigo).orElse(null);
		if(alum != null) {
			alum.setNomAlumno(alumno.getNomAlumno());
			alum.setApeAlumno(alumno.getApeAlumno());
			alum.setEmaAlumno(alumno.getEmaAlumno());
			alumnoRepository.save(alum);
			return "Alumno actualizado";
		} else return "Error";
	}
	
	@Override
	public void eliminarAlumno(int codigo) {
		
		cuentaFeign.eliminarCuentaPorAlumno(codigo);
		
		
		alumnoRepository.deleteById(codigo);	
	}
	
	@Override
	public Cuenta crearAlumnoConCuenta(Alumno alumno, Cuenta cuenta) {
		Alumno alumnoGuardado = alumnoRepository.save(alumno);
		cuenta.setCodAlumno(alumnoGuardado.getCodAlumno());
		return cuentaFeign.crearCuenta(cuenta);
	}
}
