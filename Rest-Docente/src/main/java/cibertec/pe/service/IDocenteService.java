package cibertec.pe.service;
import java.util.List;
import java.util.Optional;
import cibertec.pe.entity.Curso;
import cibertec.pe.model.Docente;

public interface IDocenteService {
	
	public List<Docente> listarDocentes();
	public Docente crearDocente(Docente docente);
	public Optional<Docente> buscarDocente(int codigo);
	public String editarDocente(int codigo, Docente docente);
	public void eliminarDocente(int codigo);
	
	public Curso crearCurso(int codDocente, Curso curso);
}