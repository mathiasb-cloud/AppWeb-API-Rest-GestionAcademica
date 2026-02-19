package cibertec.pe.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cibertec.pe.feignClient.AlumnoFeignClient;
import cibertec.pe.feignClient.CursoFeignClient;
import cibertec.pe.model.Matricula;
import cibertec.pe.repository.MatriculaRepository;
import feign.FeignException;

@Service
public class MatriculaImplement implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;
    
    @Autowired
    private AlumnoFeignClient alumnoClient;
    
    @Autowired
    private CursoFeignClient cursoClient;

    @Override
    public List<Matricula> listarMatriculas() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula crearMatricula(Matricula matricula) {
        
        try {
            alumnoClient.obtenerAlumno(matricula.getCodAlumno());
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Error: El alumno con código " + matricula.getCodAlumno() + " no existe");
        } catch (Exception e) {
            throw new RuntimeException("Error al validar el alumno: " + e.getMessage());
        }
        
        
        try {
            cursoClient.obtenerCurso(matricula.getCodCurso());
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Error: El curso con código " + matricula.getCodCurso() + " no existe");
        } catch (Exception e) {
            throw new RuntimeException("Error al validar el curso: " + e.getMessage());
        }
        
        
        return matriculaRepository.save(matricula);
    }

    @Override
    public Optional<Matricula> buscarMatricula(int id) {
        return matriculaRepository.findById(id);
    }

    @Override
    public String editarMatricula(int id, Matricula matricula) {
        Matricula mat = matriculaRepository.findById(id).orElse(null);
        if (mat != null) {
            mat.setCodAlumno(matricula.getCodAlumno());
            mat.setCodCurso(matricula.getCodCurso());
            mat.setFechaMatricula(matricula.getFechaMatricula());
            mat.setEstado(matricula.getEstado());
            matriculaRepository.save(mat);
            return "Matrícula actualizada";
        } else {
            return "Error: Matrícula no encontrada";
        }
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