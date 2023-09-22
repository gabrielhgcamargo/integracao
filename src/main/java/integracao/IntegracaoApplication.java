package integracao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger de: Integracao", version = "1.0.0", description = "Documentação das rotas de GET/POST de Cursos."))
public class IntegracaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegracaoApplication.class, args);
	}

}