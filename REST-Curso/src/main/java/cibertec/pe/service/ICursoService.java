package cibertec.pe.service;
import java.util.List;
import java.util.Optional;
import cibertec.pe.model.Curso;

public interface ICursoService {
	
	public List<Curso> listarCursos();
	public Curso crearCurso(Curso curso);
	public String asignarAlumno(int nroCurso, int codAlumno);
	public Optional<Curso> buscarCurso(int codigo);
	public String editarCurso(int codigo, Curso curso);
	public void eliminarCurso(int codigo);
	
	public List<Curso> listarCursoByCodAlumno(int codigoAlumno);
}