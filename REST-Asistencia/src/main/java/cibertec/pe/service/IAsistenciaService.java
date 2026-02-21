package cibertec.pe.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import cibertec.pe.model.Asistencia;

public interface IAsistenciaService {
	
	public List<Asistencia> listarAsistencias();
	public Asistencia registrarAsistencia(Asistencia asistencia);
	public Optional<Asistencia> buscarAsistencia(int codAsistencia);
	public String editarAsistencia(int codAsistencia, Asistencia asistencia);
	public void eliminarAsistencia(int codAsistencia);
	public List<Asistencia> listarAsistenciasPorMatricula(int codMatricula);
	public List<Asistencia> listarAsistenciasPorAlumno(int codAlumno);
	public List<Asistencia> listarAsistenciasPorCurso(int codCurso);
	public List<Asistencia> listarAsistenciasPorFecha(LocalDate fecha);
	public double calcularPorcentajeAsistencia(int codMatricula);
}