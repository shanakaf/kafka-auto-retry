package org.shanaka.test.kafkaautoretry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class KafkaAutoRetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaAutoRetryApplication.class, args);
    }

}
