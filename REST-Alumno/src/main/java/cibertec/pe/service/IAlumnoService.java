package cibertec.pe.service;
import java.util.List;
import java.util.Optional;
import cibertec.pe.entity.Curso;
import cibertec.pe.model.Alumno;

public interface IAlumnoService {
	
	public List<Alumno> listarAlumnos();
	public Alumno crearAlumno(Alumno alumno);
	public Optional<Alumno> buscarAlumno(int codigo);
	public String editarAlumno(int codigo, Alumno alumno);
	public void eliminarAlumno(int codigo);
	
	public Curso crearCurso(int codAlumno, Curso curso);
}