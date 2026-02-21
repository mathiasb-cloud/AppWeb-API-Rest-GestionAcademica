package cibertec.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class RestAsistenciaApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestAsistenciaApplication.class, args);
		System.out.println("Servicio Asistencia inicializado");
	}
}