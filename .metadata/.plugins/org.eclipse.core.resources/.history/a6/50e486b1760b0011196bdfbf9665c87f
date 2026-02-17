package cibertec.pe.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cibertec.pe.entity.Curso;
import cibertec.pe.model.Alumno;
import cibertec.pe.service.IAlumnoService;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
	
	@Autowired
	private IAlumnoService alumnoService;
	
	@GetMapping("/listAllAlumnos")
	public List<Alumno> listAllAlumnos(){
		return alumnoService.listarAlumnos();
	}
	
	@PostMapping("/createAlumno")	
	public Alumno createAlumno(@RequestBody Alumno alumno) {
		return alumnoService.crearAlumno(alumno);
	}
	
	@PutMapping("/editAlumnos/{codigo}")
	public String editAlumno(@PathVariable int codigo, @RequestBody Alumno alumno) {
		return alumnoService.editarAlumno(codigo, alumno);
	}
	
	@PostMapping("/createCurso/{codigo}")
	public Curso crearCurso(@PathVariable int codigo, @RequestBody Curso curso) {
		return alumnoService.crearCurso(codigo, curso);	
	}
}