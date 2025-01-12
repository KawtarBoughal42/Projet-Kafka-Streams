package com.project.systeme__gestion__location__vehicules.producteur.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        kafkaTemplate.send("input-topic", message);
        return ResponseEntity.ok("Message sent to Kafka");
    }
}
