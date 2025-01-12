package com.project.systeme__gestion__location__vehicules.consommateur.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "output-topic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
