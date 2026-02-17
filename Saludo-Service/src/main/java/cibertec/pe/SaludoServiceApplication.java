package cibertec.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SaludoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaludoServiceApplication.class, args);
		System.out.println("Servicio Saludo Inicializado");
	}

}
