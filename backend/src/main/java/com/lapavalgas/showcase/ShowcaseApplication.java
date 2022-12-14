package com.lapavalgas.showcase;

import com.lapavalgas.showcase.domain.DTO;
import com.lapavalgas.showcase.domain.Mapper;
import com.lapavalgas.showcase.domain.repository.CustomerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ShowcaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowcaseApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping("/graphql/**")
                        .allowedOrigins(CorsConfiguration.ALL)
                        .allowedHeaders(CorsConfiguration.ALL)
                        .allowedMethods(CorsConfiguration.ALL);
            }
        };
    }

    @Bean
    ApplicationRunner applicationRunner(CustomerRepository customerRepository) {
        return args -> {
            var d1 = new DTO();
            d1.setCpf("011.879.630-54");
            d1.setNome("Rafael da Silva");
            d1.setEmail("dasilvar@customer.com");
            d1.setTelefone("(48) 98888-1313");
            d1.setCep("88803-140");
            d1.setLogradouro("Rua Thomé de Souza");
            d1.setNumero("2321");
            d1.setComplemento("Na esquina com a casa de madeira velha");
            d1.setBairro("Michel");
            d1.setLocalidade("Criciúma");
            d1.setUf("SC");
            d1.setIbge("4204608");
            var c1 = Mapper.dtoToCustomerFullParse(d1);
            customerRepository.save(c1);

            var d2 = new DTO();
            d2.setCpf("033.772.890-97");
            d2.setNome("Paula Curzio");
            d2.setEmail("ulacurzio@customer.com");
            d2.setTelefone("(48) 98876-0213");
            d2.setCep("88067-140");
            d2.setLogradouro("Rua Manoel Vidal");
            d2.setNumero("1A");
            d2.setComplemento("Ed. Azul, Ap. 61");
            d2.setBairro("Pântano do Sul");
            d2.setLocalidade("Florianópolis");
            d2.setUf("SC");
            d2.setIbge("4205407");
            var c2 = Mapper.dtoToCustomerFullParse(d2);
            customerRepository.save(c2);
        };
    }

}
