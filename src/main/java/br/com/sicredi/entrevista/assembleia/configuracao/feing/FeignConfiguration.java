package br.com.sicredi.entrevista.assembleia.teste.configuracao.feing;

import br.com.sicredi.entrevista.assembleia.teste.client.CPFClient;
import feign.Feign;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    static feign.Logger.Level feignLoggerLevelApp() {
        return feign.Logger.Level.BASIC;
    }

    @Autowired
    private FeignProperties properties;

    @Bean
    public CPFClient cpfClient() {
        return createClient(CPFClient.class, properties.getServicoCpf());
    }

    protected static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .decode404()
                .client(new ApacheHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logLevel(feignLoggerLevelApp())
                .target(type, uri);
    }


}