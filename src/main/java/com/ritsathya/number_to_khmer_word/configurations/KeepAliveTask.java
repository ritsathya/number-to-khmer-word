package com.ritsathya.number_to_khmer_word.configurations;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KeepAliveTask {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://number-to-khmer-word.onrender.com/api/v1/ping";

    @Scheduled(fixedRate = 300000) // Runs every 1 minute
    public void sendKeepAliveRequest() {
        try {
            restTemplate.getForObject(API_URL, String.class);
            System.out.println("Keep-alive request sent to " + API_URL);
        } catch (Exception e) {
            System.err.println("Failed to send keep-alive request: " + e.getMessage());
        }
    }
}
