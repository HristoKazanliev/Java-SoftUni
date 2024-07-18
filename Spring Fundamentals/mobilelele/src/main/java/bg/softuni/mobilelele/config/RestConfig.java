package bg.softuni.mobilelele.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
    @Bean("genericRestClient")
    public RestClient genericRestClient() {
        return RestClient.create();
    }
}
