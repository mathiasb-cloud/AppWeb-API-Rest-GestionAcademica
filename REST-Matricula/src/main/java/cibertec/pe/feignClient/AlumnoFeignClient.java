package cibertec.pe.feignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "REST-ALUMNO", url = "http://localhost:9002")
public interface AlumnoFeignClient {
    
    @GetMapping("/api/alumno/{id}")
    Object obtenerAlumno(@PathVariable("id") int id);
}