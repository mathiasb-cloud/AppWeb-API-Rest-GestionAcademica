package cibertec.pe.controller;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import cibertec.pe.model.Asistencia;
import cibertec.pe.service.IAsistenciaService;

@RestController
@RequestMapping("/api/asistencias")
public class AsistenciaController {
	
	@Autowired
	private IAsistenciaService asistenciaService;
	
	@GetMapping("/listar")
	public List<Asistencia> listarAsistencias() {
		return asistenciaService.listarAsistencias();
	}
	
	@GetMapping("/{id}")
	public Optional<Asistencia> buscarAsistencia(@PathVariable int id) {
		return asistenciaService.buscarAsistencia(id);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Object> registrarAsistencia(@RequestBody Asistencia asistencia) {
		try {
			Asistencia nuevaAsistencia = asistenciaService.registrarAsistencia(asistencia);
			return ResponseEntity.ok(nuevaAsistencia);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno: " + e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public String editarAsistencia(@PathVariable int id, @RequestBody Asistencia asistencia) {
		return asistenciaService.editarAsistencia(id, asistencia);
	}
	
	@DeleteMapping("/{id}")
	public String eliminarAsistencia(@PathVariable int id) {
		asistenciaService.eliminarAsistencia(id);
		return "Asistencia eliminada correctamente";
	}
	
	@GetMapping("/porMatricula/{codMatricula}")
	public List<Asistencia> listarAsistenciasPorMatricula(@PathVariable int codMatricula) {
		return asistenciaService.listarAsistenciasPorMatricula(codMatricula);
	}
	
	@GetMapping("/porAlumno/{codAlumno}")
	public List<Asistencia> listarAsistenciasPorAlumno(@PathVariable int codAlumno) {
		return asistenciaService.listarAsistenciasPorAlumno(codAlumno);
	}
	
	@GetMapping("/porCurso/{codCurso}")
	public List<Asistencia> listarAsistenciasPorCurso(@PathVariable int codCurso) {
		return asistenciaService.listarAsistenciasPorCurso(codCurso);
	}
	
	@GetMapping("/porFecha/{fecha}")
	public List<Asistencia> listarAsistenciasPorFecha(
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
		return asistenciaService.listarAsistenciasPorFecha(fecha);
	}
	
	@GetMapping("/porcentaje/{codMatricula}")
	public ResponseEntity<Object> calcularPorcentajeAsistencia(@PathVariable int codMatricula) {
		double porcentaje = asistenciaService.calcularPorcentajeAsistencia(codMatricula);
		return ResponseEntity.ok("Porcentaje de asistencia: " + String.format("%.2f", porcentaje) + "%");
	}
}