package br.com.sicredi.entrevista.assembleia.configuracao.feing;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "configuracoes")
public class FeignProperties {
    private String servicoCpf;

}