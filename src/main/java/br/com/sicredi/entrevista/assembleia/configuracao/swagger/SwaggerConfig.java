package br.com.sicredi.entrevista.assembleia.configuracao.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class SwaggerConfig {

    @Value("${config.swagger.path}")
    private String swaggerpath;

    @Bean
    public Docket productApi() {
        Set<String> protolocos = new HashSet<>();
        protolocos.add("http");
        protolocos.add("https");

        return new Docket(DocumentationType.SWAGGER_2).host(swaggerpath)
                .groupName("All")
                .select()
                .paths(PathSelectors.any())
                .apis( RequestHandlerSelectors.basePackage( "br.com.sicredi.entrevista.assembleia" ) )
                .build()
                .protocols(protolocos)
                .ignoredParameterTypes(ApiIgnore.class)
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Votação - REST API")
                .description("API para realização de votações em assembleia")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Rodrigo Araújo", "https://github.com/rodrigo2005", "rodrigo.rsa2005@gmail.com"))
                .build();
    }

}
