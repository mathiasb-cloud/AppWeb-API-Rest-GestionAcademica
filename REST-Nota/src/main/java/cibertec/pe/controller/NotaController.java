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
import cibertec.pe.model.Nota;
import cibertec.pe.service.INotaService;

@RestController
@RequestMapping("/api/notas")
public class NotaController {
	
	@Autowired
	private INotaService notaService;
	
	@GetMapping("/listar")
	public List<Nota> listarNotas() {
		return notaService.listarNotas();
	}
	
	@GetMapping("/buscarNota/{id}")
	public Optional<Nota> buscarNota(@PathVariable int id) {
		return notaService.buscarNota(id);
	}
	
	@PostMapping("/crearNota")
	public ResponseEntity<Object> crearNota(@RequestBody Nota nota) {
		try {
			Nota nuevaNota = notaService.crearNota(nota);
			return ResponseEntity.ok(nuevaNota);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno: " + e.getMessage());
		}
	}
	
	@PutMapping("/editarNota/{id}")
	public String editarNota(@PathVariable int id, @RequestBody Nota nota) {
		return notaService.editarNota(id, nota);
	}
	
	@DeleteMapping("/eliminarNota/{id}")
	public String eliminarNota(@PathVariable int id) {
		notaService.eliminarNota(id);
		return "Nota eliminada correctamente";
	}
	
	@GetMapping("/porMatricula/{codMatricula}")
	public List<Nota> listarNotasPorMatricula(@PathVariable int codMatricula) {
		return notaService.listarNotasPorMatricula(codMatricula);
	}
	
	@GetMapping("/porAlumno/{codAlumno}")
	public List<Nota> listarNotasPorAlumno(@PathVariable int codAlumno) {
		return notaService.listarNotasPorAlumno(codAlumno);
	}
	
	@GetMapping("/porCurso/{codCurso}")
	public List<Nota> listarNotasPorCurso(@PathVariable int codCurso) {
		return notaService.listarNotasPorCurso(codCurso);
	}
}