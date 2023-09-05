package br.com.avaliao.avaliaodesafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class AvaliaoDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run( AvaliaoDesafioApplication.class, args );
	}
	@GetMapping
	public String initProject() {
		return "Bem vindo(a), ao PessoaManager";
	}
}
