package cibertec.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RestCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCursoApplication.class, args);
		System.out.println("Servicio Curso inicializado");	
	}
}