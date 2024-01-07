package be.helb.smakani.configuration;

import be.helb.smakani.destination.DataAcessDestinationClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class FeignConfiguration {

    @Bean
    @Qualifier("dataAcessDestinationClient")
    public DataAcessDestinationClient dataAcessDestinationClient(){
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(DataAcessDestinationClient.class,"localhost:8081");
    }
}
