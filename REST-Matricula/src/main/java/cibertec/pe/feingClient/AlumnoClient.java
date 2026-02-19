package cibertec.pe.feingClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "alumno-service", url = "http://localhost:9002")
public interface AlumnoClient {

    @GetMapping("/alumno/{id}")
    Object obtenerAlumno(@PathVariable("id") int id);
}