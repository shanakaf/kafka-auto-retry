package org.shanaka.test.kafkaautoretry.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static org.shanaka.test.kafkaautoretry.Util.KafkaUtils.MESSAGE_TOPIC;

@Service
@Slf4j
public class KafkaMessageProducerService {

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaMessageProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceMessage(String message) {
        log.info("Sending message {} ", message);
        kafkaTemplate.send(MESSAGE_TOPIC, message);
    }
}
