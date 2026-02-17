package cibertec.pe.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cibertec.pe.model.Cuenta;
import cibertec.pe.service.ICuentaService;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {
	
	@Autowired
	private ICuentaService cuentaService;
	
	@GetMapping("/listAllCuentas")
	public List<Cuenta> getAllCuentas(){
		return cuentaService.listarCuentas();
	}
	
	@PostMapping("/createCuenta")	
	public Cuenta createCuenta(@RequestBody Cuenta cuenta) {
		return cuentaService.crearCuenta(cuenta);
	}
	
	@GetMapping("/byCodAlumno/{codigo}")
	public Cuenta getCuentaByCodAlumno(@PathVariable int codigo){
		return cuentaService.buscarCuentaPorCodAlumno(codigo);
	}
	
	@PutMapping("/editCuenta/{codUsuario}")
	public String editCuenta(@PathVariable String codUsuario, @RequestBody Cuenta cuenta) {
		return cuentaService.editarCuenta(codUsuario, cuenta);
	}
	
	@DeleteMapping("/deleteCuentaByAlumno/{codAlumno}")
	public String deleteCuentaByAlumno(@PathVariable int codAlumno) {
		cuentaService.eliminarCuentaPorAlumno(codAlumno);
		return "Cuenta del alumno eliminada correctamente";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Cuenta cuenta) {
		return cuentaService.validarLogin(cuenta.getCodUsuario(), cuenta.getContrasena());
	}
}