package com.triagemsys.TriagemSysBackend.infra.web;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class OpenAPIConfig {

    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("joaogdantasdev@gmail.com");
        contact.setName("João Gabriel");
        contact.setUrl("https://www.linkedin.com/in/joaogdantas/");

        License license = new License().name("Licença - João Gabriel").url("https://www.linkedin.com/in/joaogdantas/");

        Info info = new Info()
                .title("TriagemSysBackend")
                .version("0.0.1")
                .contact(contact)
                .description("Desenvolvimento da API em Java para o projeto de codinome TriagemSys")
                .termsOfService("https://github.com/joaogdantas/TriagemSysBackend")
                .license(license);

        return new OpenAPI().info(info).servers(Collections.singletonList(devServer));
    }
}
