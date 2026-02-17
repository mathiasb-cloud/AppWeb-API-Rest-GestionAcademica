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
import cibertec.pe.entity.Curso;
import cibertec.pe.model.Docente;
import cibertec.pe.service.IDocenteService;

@RestController
@RequestMapping("/api/docente")
public class DocenteController {
	
	@Autowired
	private IDocenteService docenteService;
	
	@GetMapping("/listAllDocentes")
	public List<Docente> listAllDocentes(){
		return docenteService.listarDocentes();
	}
	
	@PostMapping("/createDocente")	
	public Docente createDocente(@RequestBody Docente docente) {
		return docenteService.crearDocente(docente);
	}
	
	@PutMapping("/editDocentes/{codigo}")
	public String editDocente(@PathVariable int codigo, @RequestBody Docente docente) {
		return docenteService.editarDocente(codigo, docente);
	}
	
	@PostMapping("/createCurso/{codigo}")
	public Curso crearCurso(@PathVariable int codigo, @RequestBody Curso curso) {
		return docenteService.crearCurso(codigo, curso);	
	}
	
	
	@DeleteMapping("/deleteDocente/{codigo}")
	public String deleteDocente(@PathVariable int codigo) {
		docenteService.eliminarDocente(codigo);
		return "Docente eliminado correctamente";
	}
}