package cibertec.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class RestNotaApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestNotaApplication.class, args);
		System.out.println("Servicio Nota inicializado");
	}
}