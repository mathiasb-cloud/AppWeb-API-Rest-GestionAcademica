package cibertec.pe.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("/byCodDocente/{codigo}")
	public List<Curso> listarCursoByCodDocente(@PathVariable int codigo){
		return cursoService.listarCursoByCodDocente(codigo);
	}
	
	@DeleteMapping("/deleteCurso/{nroCurso}")
	public String deleteCurso(@PathVariable int nroCurso) {
		cursoService.eliminarCurso(nroCurso);
		return "Curso eliminado correctamente";
	}
	
	@PutMapping("/asignarDocente/{nroCurso}/{codDocente}")
	public String asignarDocente(@PathVariable int nroCurso, @PathVariable int codDocente) {
		return cursoService.asignarDocente(nroCurso, codDocente);
	}
	
	
	@PutMapping("/editCurso/{nroCurso}")
	public String editCurso(@PathVariable int nroCurso, @RequestBody Curso curso) {
		return cursoService.editarCurso(nroCurso, curso);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> getCursoById(@PathVariable int id) {
		Optional<Curso> curso = cursoService.buscarCurso(id);
		if (curso.isPresent()) {
			return ResponseEntity.ok(curso.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}