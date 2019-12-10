package com.raf.infoservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.io.IOException;
import java.util.Collections;

@Configuration
public class FootballDataApiConfiguration {

    @Bean
    public RestTemplate FootballDataApiClient() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://api.football-data.org/v2"));
        restTemplate.setInterceptors(Collections.singletonList(new FootballDataApiTokenInterceptor()));
        return restTemplate;
    }

    private class FootballDataApiTokenInterceptor implements ClientHttpRequestInterceptor {

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                            ClientHttpRequestExecution execution) throws IOException {
            HttpHeaders headers = request.getHeaders();
            headers.add("X-Auth-Token", "5aa0c841d86642fca19dac9665b33e55");
            return execution.execute(request, body);
        }
    }
}