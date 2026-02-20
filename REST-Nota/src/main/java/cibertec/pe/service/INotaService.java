package cibertec.pe.service;
import java.util.List;
import java.util.Optional;
import cibertec.pe.model.Nota;

public interface INotaService {
	
	public List<Nota> listarNotas();
	public Nota crearNota(Nota nota);
	public Optional<Nota> buscarNota(int codNota);
	public String editarNota(int codNota, Nota nota);
	public void eliminarNota(int codNota);
	public List<Nota> listarNotasPorMatricula(int codMatricula);
	public List<Nota> listarNotasPorAlumno(int codAlumno);
	public List<Nota> listarNotasPorCurso(int codCurso);
}