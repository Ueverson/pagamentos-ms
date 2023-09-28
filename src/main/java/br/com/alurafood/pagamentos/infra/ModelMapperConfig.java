package br.com.alurafood.pagamentos.infra;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	
	@Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
