package cibertec.pe.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cibertec.pe.model.Curso;
import cibertec.pe.repository.ICursoRepository;

@Service
public class CursoImplement implements ICursoService {
	
	@Autowired
	private ICursoRepository cursoRepository;
	
	@Override
	public List<Curso> listarCursos() {
		return cursoRepository.findAll();
	}
	
	@Override
	public Curso crearCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	@Override
	public Optional<Curso> buscarCurso(int codigo) {
		return cursoRepository.findById(codigo);
	}
	
	@Override
	public String editarCurso(int nroCurso, Curso curso) {
		Curso cur = cursoRepository.findById(nroCurso).orElse(null);
		if(cur != null) {
			cur.setNomCurso(curso.getNomCurso());
			cur.setCiclo(curso.getCiclo());
			
			if(curso.getCodDocente() != null) {
				cur.setCodDocente(curso.getCodDocente());
			}
			cursoRepository.save(cur);
			return "Curso actualizado";
		} else {
			return "Error: Curso no encontrado";
		}
	}
	
	@Override
	public void eliminarCurso(int codigo) {
		cursoRepository.deleteById(codigo);	
	}
	
	@Override
	public List<Curso> listarCursoByCodDocente(int codDocente) {
		return cursoRepository.findByCodDocente(codDocente);
	}
	
	@Override
	public String asignarDocente(int nroCurso, int codDocente) {
		Curso curso = cursoRepository.findById(nroCurso).orElse(null);
		if(curso != null) {
			curso.setCodDocente(codDocente);
			cursoRepository.save(curso);
			return "Docente asignado al curso correctamente";
		} else {
			return "Error: Curso no encontrado";
		}
	}
}