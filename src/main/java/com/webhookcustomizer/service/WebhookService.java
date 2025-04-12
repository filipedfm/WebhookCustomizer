package com.webhookcustomizer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WebhookService {

    @Value("${downstream.service.url}")
    private String downstreamServiceUrl;

    @Value("${downstream.service.token}")
    private String downstreamServiceToken;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void processAndForwardPayload(String payload) {
        try {
            // Parse the incoming payload
            Map<String, Object> incomingPayload = objectMapper.readValue(payload, Map.class);

            // Transform the payload for the downstream service
            Map<String, Object> transformedPayload = transformPayload(incomingPayload);

            // Forward the transformed payload to the downstream service
            forwardToDownstreamService(transformedPayload);
        } catch (Exception e) {
            throw new RuntimeException("Failed to process and forward payload", e);
        }
    }

    private Map<String, Object> transformPayload(Map<String, Object> incomingPayload) {
        // Example transformation logic (can be customized as needed)
        return Map.of(
            "ref", "main",
            "inputs", incomingPayload
        );
    }

    private void forwardToDownstreamService(Map<String, Object> payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + downstreamServiceToken);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);

        restTemplate.postForEntity(
            downstreamServiceUrl,
            requestEntity,
            String.class
        );
    }
}