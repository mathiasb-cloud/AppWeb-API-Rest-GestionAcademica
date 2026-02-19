package cibertec.pe.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cibertec.pe.model.Matricula;
import cibertec.pe.service.IMatriculaService;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {
    
    @Autowired
    private IMatriculaService matriculaService;
    
    @GetMapping("/listar")
    public List<Matricula> listar() {
        return matriculaService.listarMatriculas();
    }
    
    @GetMapping("/{id}")
    public Optional<Matricula> buscar(@PathVariable int id) {
        return matriculaService.buscarMatricula(id);
    }
    
    @PostMapping("/crearMatricula")
    public ResponseEntity<Object> crear(@RequestBody Matricula matricula) {
        try {
            Matricula nuevaMatricula = matriculaService.crearMatricula(matricula);
            return ResponseEntity.ok(nuevaMatricula);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno: " + e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public String editar(@PathVariable int id, @RequestBody Matricula matricula) {
        return matriculaService.editarMatricula(id, matricula);
    }
    
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        matriculaService.eliminarMatricula(id);
    }
    
    @GetMapping("/alumno/{alumnoId}")
    public List<Matricula> listarPorAlumno(@PathVariable int alumnoId) {
        return matriculaService.listarPorAlumno(alumnoId);
    }
    
    @GetMapping("/curso/{cursoId}")
    public List<Matricula> listarPorCurso(@PathVariable int cursoId) {
        return matriculaService.listarPorCurso(cursoId);
    }
}