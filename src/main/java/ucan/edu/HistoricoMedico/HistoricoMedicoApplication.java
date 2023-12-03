package ucan.edu.HistoricoMedico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ucan.edu.HistoricoMedico.*")

public class HistoricoMedicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistoricoMedicoApplication.class, args);
	}

}
