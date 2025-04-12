package com.webhookcustomizer.controller;

import com.webhookcustomizer.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @Autowired
    private WebhookService webhookService;

    @PostMapping
    public ResponseEntity<String> handleWebhook(@RequestBody String payload) {
        webhookService.processAndForwardPayload(payload);
        return ResponseEntity.ok("Webhook processed and forwarded successfully");
    }
}