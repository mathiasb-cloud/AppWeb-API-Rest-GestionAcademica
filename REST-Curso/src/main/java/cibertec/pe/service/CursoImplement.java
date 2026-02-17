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
	public String asignarAlumno(int nroCurso, int codAlumno) {
		Curso curso = cursoRepository.findById(nroCurso).orElse(null);
		if(curso != null) {
			curso.setCodAlumno(codAlumno);
			cursoRepository.save(curso);
			return "Alumno asignado al curso correctamente";
		} else {
			return "Error: Curso no encontrado";
		}
	}
	
	@Override
	public Optional<Curso> buscarCurso(int codigo) {
		return cursoRepository.findById(codigo);
	}
	
	@Override
	public String editarCurso(int codigo, Curso curso) {
		Curso cur = cursoRepository.findById(codigo).get();
		if(cur != null) {
			cur.setNomCurso(curso.getNomCurso());
			cur.setCiclo(curso.getCiclo());
			cursoRepository.save(cur);
			return "Curso actualizado";
		} else return "Error";
	}
	
	@Override
	public void eliminarCurso(int codigo) {
		cursoRepository.deleteById(codigo);	
	}
	
	@Override
	public List<Curso> listarCursoByCodAlumno(int codigoAlumno) {
		return cursoRepository.findByCodAlumno(codigoAlumno);
	}
}