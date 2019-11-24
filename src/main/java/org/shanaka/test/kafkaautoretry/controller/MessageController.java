package org.shanaka.test.kafkaautoretry.controller;

import org.shanaka.test.kafkaautoretry.service.KafkaMessageProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final KafkaMessageProducerService kafkaMessageProducerService;

    public MessageController(KafkaMessageProducerService kafkaMessageProducerService) {
        this.kafkaMessageProducerService = kafkaMessageProducerService;
    }

    @PostMapping
    public ResponseEntity<Void> addMessage(@RequestParam("message") String message) {
        kafkaMessageProducerService.produceMessage(message);
        return ResponseEntity.ok().build();
    }

}
