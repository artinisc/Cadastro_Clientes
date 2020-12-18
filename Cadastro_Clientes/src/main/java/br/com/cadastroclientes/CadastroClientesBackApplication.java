package br.com.cadastroclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.com.cadastroclientes.ws.controller.TokenFilter;

@SpringBootApplication
public class CadastroClientesBackApplication {

	@Bean
	public FilterRegistrationBean filtroJwt() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/privado/*");
		return frb;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CadastroClientesBackApplication.class, args);
	}

}
