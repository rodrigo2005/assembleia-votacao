package br.com.sicredi.entrevista.assembleia.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.TimeZone;

@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class AssembleiaApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(AssembleiaApplication.class, args);
	}

}
