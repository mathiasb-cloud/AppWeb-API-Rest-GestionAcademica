package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import cibertec.pe.model.Matricula;

public interface IMatriculaService {

	List<Matricula> listarMatriculas();

    Matricula crearMatricula(Matricula matricula);

    Optional<Matricula> buscarMatricula(int id);

    String editarMatricula(int id, Matricula matricula);

    void eliminarMatricula(int id);

    List<Matricula> listarPorAlumno(int alumnoId);

    List<Matricula> listarPorCurso(int cursoId);
}
