package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.model.Matricula;
import cibertec.pe.repository.MatriculaRepository;

@Service
public class MatriculaImplement implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> listarMatriculas() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula crearMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Optional<Matricula> buscarMatricula(int id) {
        return matriculaRepository.findById(id);
    }

    @Override
    public String editarMatricula(int id, Matricula matricula) {

        Optional<Matricula> existente = matriculaRepository.findById(id);

        if (existente.isPresent()) {
            Matricula m = existente.get();

            m.setCodAlumno(matricula.getCodAlumno());
            m.setCodCurso(matricula.getCodCurso());
            m.setFechaMatricula(matricula.getFechaMatricula());
            m.setEstado(matricula.getEstado());

            matriculaRepository.save(m);
            return "Matrícula actualizada correctamente";
        }

        return "Matricula no encontrada";
    }

    @Override
    public void eliminarMatricula(int id) {
        matriculaRepository.deleteById(id);
    }

    @Override
    public List<Matricula> listarPorAlumno(int alumnoId) {
        return matriculaRepository.findByCodAlumno(alumnoId);
    }

    @Override
    public List<Matricula> listarPorCurso(int cursoId) {
        return matriculaRepository.findByCodCurso(cursoId);
    }

}
