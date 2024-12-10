package br.com.relacionamento.no.sql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class RelacionamentosNosqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelacionamentosNosqlApplication.class, args);
	}

}
