package com.raf.infoservice.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.infoservice.dto.MatchesDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetResultsScheduler {

    private RestTemplate footballDataApiClient;
    private JmsTemplate jmsTemplate;
    private ObjectMapper objectMapper;
    private String emailQueueDestination;

    public GetResultsScheduler(RestTemplate footballDataApiClient, JmsTemplate jmsTemplate, ObjectMapper objectMapper,
                               @Value("${destination.sendEmails}") String emailQueueDestination) {

        this.footballDataApiClient = footballDataApiClient;
        this.jmsTemplate = jmsTemplate;
        this.objectMapper = objectMapper;
        this.emailQueueDestination = emailQueueDestination;
    }

    @Scheduled(initialDelay = 10000, fixedRate = 10000)
    public void getPremierLeagueResults() throws JsonProcessingException {
        ResponseEntity<MatchesDto> matchesDtoResponseEntity = footballDataApiClient
                .exchange("/competitions/2021/matches?matchday=16", HttpMethod.GET, null, MatchesDto.class);
        if (matchesDtoResponseEntity.getStatusCode().equals(HttpStatus.OK))
            jmsTemplate.convertAndSend(emailQueueDestination, objectMapper
                    .writeValueAsString(matchesDtoResponseEntity.getBody()));
    }
}
