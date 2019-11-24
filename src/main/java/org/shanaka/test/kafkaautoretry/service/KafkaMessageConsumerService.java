package org.shanaka.test.kafkaautoretry.service;

import lombok.extern.slf4j.Slf4j;
import org.shanaka.test.kafkaautoretry.Util.KafkaUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageConsumerService {

    @KafkaListener(topics = KafkaUtils.MESSAGE_TOPIC, groupId = KafkaUtils.MESSAGE_GROUP)
    public void onCustomerMessage(String message) throws Exception {
        log.info("Message : {}  is received", message);
        if (message.contains("Test")) {
            log.info("Incompatible message {} ", message);
            throw new RuntimeException("Incompatible message " + message);
        }
    }
}
