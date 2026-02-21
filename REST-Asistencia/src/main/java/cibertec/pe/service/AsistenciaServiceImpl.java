package cibertec.pe.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import cibertec.pe.entity.Matricula;
import cibertec.pe.feignclient.MatriculaFeignClient;
import cibertec.pe.model.Asistencia;
import cibertec.pe.repository.IAsistenciaRepository;
import feign.FeignException;

@Service
public class AsistenciaServiceImpl implements IAsistenciaService {
	
	@Autowired
	private IAsistenciaRepository asistenciaRepository;
	
	@Autowired
	private MatriculaFeignClient matriculaClient;
	
	@Override
	public List<Asistencia> listarAsistencias() {
		return asistenciaRepository.findAll();
	}
	
	@Override
	public Asistencia registrarAsistencia(Asistencia asistencia) {
		
		try {
			ResponseEntity<Matricula> response = matriculaClient.obtenerMatricula(asistencia.getCodMatricula());
			if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
				return asistenciaRepository.save(asistencia);
			} else {
				throw new RuntimeException("Error: La matrícula con código " + asistencia.getCodMatricula() + " no existe");
			}
		} catch (FeignException.NotFound e) {
			throw new RuntimeException("Error: La matrícula con código " + asistencia.getCodMatricula() + " no existe");
		} catch (Exception e) {
			throw new RuntimeException("Error al validar la matrícula: " + e.getMessage());
		}
	}
	
	@Override
	public Optional<Asistencia> buscarAsistencia(int codAsistencia) {
		return asistenciaRepository.findById(codAsistencia);
	}
	
	@Override
	public String editarAsistencia(int codAsistencia, Asistencia asistencia) {
		Asistencia asistenciaExistente = asistenciaRepository.findById(codAsistencia).orElse(null);
		if (asistenciaExistente != null) {
			asistenciaExistente.setFecha(asistencia.getFecha());
			asistenciaExistente.setEstado(asistencia.getEstado());
			asistenciaExistente.setObservaciones(asistencia.getObservaciones());
			asistenciaRepository.save(asistenciaExistente);
			return "Asistencia actualizada correctamente";
		} else {
			return "Error: Asistencia no encontrada";
		}
	}
	
	@Override
	public void eliminarAsistencia(int codAsistencia) {
		asistenciaRepository.deleteById(codAsistencia);
	}
	
	@Override
	public List<Asistencia> listarAsistenciasPorMatricula(int codMatricula) {
		return asistenciaRepository.findByCodMatricula(codMatricula);
	}
	
	@Override
	public List<Asistencia> listarAsistenciasPorAlumno(int codAlumno) {
		List<Asistencia> todasLasAsistencias = asistenciaRepository.findAll();
		List<Asistencia> asistenciasDelAlumno = new ArrayList<>();
		
		for (Asistencia asistencia : todasLasAsistencias) {
			try {
				ResponseEntity<Matricula> response = matriculaClient.obtenerMatricula(asistencia.getCodMatricula());
				if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
					Matricula matricula = response.getBody();
					if (matricula.getCodAlumno() == codAlumno) {
						asistenciasDelAlumno.add(asistencia);
					}
				}
			} catch (Exception e) {
				
			}
		}
		
		return asistenciasDelAlumno;
	}
	
	@Override
	public List<Asistencia> listarAsistenciasPorCurso(int codCurso) {
		List<Asistencia> todasLasAsistencias = asistenciaRepository.findAll();
		List<Asistencia> asistenciasDelCurso = new ArrayList<>();
		
		for (Asistencia asistencia : todasLasAsistencias) {
			try {
				ResponseEntity<Matricula> response = matriculaClient.obtenerMatricula(asistencia.getCodMatricula());
				if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
					Matricula matricula = response.getBody();
					if (matricula.getCodCurso() == codCurso) {
						asistenciasDelCurso.add(asistencia);
					}
				}
			} catch (Exception e) {
				
			}
		}
		
		return asistenciasDelCurso;
	}
	
	@Override
	public List<Asistencia> listarAsistenciasPorFecha(LocalDate fecha) {
		return asistenciaRepository.findByFecha(fecha);
	}
	
	@Override
	public double calcularPorcentajeAsistencia(int codMatricula) {
		List<Asistencia> asistencias = asistenciaRepository.findByCodMatricula(codMatricula);
		
		if (asistencias.isEmpty()) {
			return 0.0;
		}
		
		long asistenciasPresentes = asistencias.stream()
				.filter(a -> "Presente".equalsIgnoreCase(a.getEstado()) || "Tardanza".equalsIgnoreCase(a.getEstado()))
				.count();
		
		return (asistenciasPresentes * 100.0) / asistencias.size();
	}
}