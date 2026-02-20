package cibertec.pe.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import cibertec.pe.entity.Matricula;
import cibertec.pe.feignclient.MatriculaFeignClient;
import cibertec.pe.model.Nota;
import cibertec.pe.repository.INotaRepository;
import feign.FeignException;

@Service
public class NotaServiceImpl implements INotaService {
	
	@Autowired
	private INotaRepository notaRepository;
	
	@Autowired
	private MatriculaFeignClient matriculaClient;
	
	@Override
	public List<Nota> listarNotas() {
		return notaRepository.findAll();
	}
	
	@Override
	public Nota crearNota(Nota nota) {
		
		try {
			ResponseEntity<Matricula> response = matriculaClient.obtenerMatricula(nota.getCodMatricula());
			if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
				
				return notaRepository.save(nota);
			} else {
				throw new RuntimeException("Error: La matrícula con código " + nota.getCodMatricula() + " no existe");
			}
		} catch (FeignException.NotFound e) {
			throw new RuntimeException("Error: La matrícula con código " + nota.getCodMatricula() + " no existe");
		} catch (Exception e) {
			throw new RuntimeException("Error al validar la matrícula: " + e.getMessage());
		}
	}
	
	@Override
	public Optional<Nota> buscarNota(int codNota) {
		return notaRepository.findById(codNota);
	}
	
	@Override
	public String editarNota(int codNota, Nota nota) {
		Nota notaExistente = notaRepository.findById(codNota).orElse(null);
		if (notaExistente != null) {
			notaExistente.setTipoEvaluacion(nota.getTipoEvaluacion());
			notaExistente.setNota(nota.getNota());
			notaExistente.setFechaEvaluacion(nota.getFechaEvaluacion());
			notaExistente.setObservaciones(nota.getObservaciones());
			notaRepository.save(notaExistente);
			return "Nota actualizada correctamente";
		} else {
			return "Error: Nota no encontrada";
		}
	}
	
	@Override
	public void eliminarNota(int codNota) {
		notaRepository.deleteById(codNota);
	}
	
	@Override
	public List<Nota> listarNotasPorMatricula(int codMatricula) {
		return notaRepository.findByCodMatricula(codMatricula);
	}
	
	@Override
	public List<Nota> listarNotasPorAlumno(int codAlumno) {
		
		List<Nota> todasLasNotas = notaRepository.findAll();
		List<Nota> notasDelAlumno = new ArrayList<>();
		
		for (Nota nota : todasLasNotas) {
			try {
				ResponseEntity<Matricula> response = matriculaClient.obtenerMatricula(nota.getCodMatricula());
				if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
					Matricula matricula = response.getBody();
					if (matricula.getCodAlumno() == codAlumno) {
						notasDelAlumno.add(nota);
					}
				}
			} catch (Exception e) {
				
			}
		}
		
		return notasDelAlumno;
	}
	
	@Override
	public List<Nota> listarNotasPorCurso(int codCurso) {
		
		List<Nota> todasLasNotas = notaRepository.findAll();
		List<Nota> notasDelCurso = new ArrayList<>();
		
		for (Nota nota : todasLasNotas) {
			try {
				ResponseEntity<Matricula> response = matriculaClient.obtenerMatricula(nota.getCodMatricula());
				if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
					Matricula matricula = response.getBody();
					if (matricula.getCodCurso() == codCurso) {
						notasDelCurso.add(nota);
					}
				}
			} catch (Exception e) {
				
			}
		}
		
		return notasDelCurso;
	}
}