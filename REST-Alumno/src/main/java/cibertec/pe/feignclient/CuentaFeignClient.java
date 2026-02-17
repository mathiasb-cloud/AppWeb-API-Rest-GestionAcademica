package cibertec.pe.feignclient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import cibertec.pe.entity.Cuenta;

@FeignClient(name = "REST-CUENTA", url = "http://localhost:9005")
public interface CuentaFeignClient {
	
	@PostMapping("/api/cuenta/createCuenta")
	Cuenta crearCuenta(@RequestBody Cuenta cuenta);
	
	@DeleteMapping("/api/cuenta/deleteCuentaByAlumno/{codAlumno}")
	String eliminarCuentaPorAlumno(@PathVariable int codAlumno);
}