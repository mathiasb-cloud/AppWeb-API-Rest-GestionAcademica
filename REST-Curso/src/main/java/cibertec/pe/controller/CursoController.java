package cibertec.pe.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cibertec.pe.model.Curso;
import cibertec.pe.service.ICursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {
	
	@Autowired
	private ICursoService cursoService;
	
	@GetMapping("/listAllCursos")
	public List<Curso> getAllCursos(){
		return cursoService.listarCursos();
	}
	
	@PostMapping("/createCurso")	
	public Curso createCurso(@RequestBody Curso curso) {
		return cursoService.crearCurso(curso);
	}	
	
	@PutMapping("/asignarAlumno/{nroCurso}/{codAlumno}")
	public String asignarAlumnoACurso(@PathVariable int nroCurso, @PathVariable int codAlumno) {
		return cursoService.asignarAlumno(nroCurso, codAlumno);
	}
	
	@GetMapping("/byCodAlumno/{codigo}")
	public List<Curso> listarCursoByCodAlumno(@PathVariable int codigo){
		return cursoService.listarCursoByCodAlumno(codigo);
	}
	
	@DeleteMapping("/deleteCurso/{nroCurso}")
	public String deleteCurso(@PathVariable int nroCurso) {
		cursoService.eliminarCurso(nroCurso);
		return "Curso eliminado correctamente";
	}
}