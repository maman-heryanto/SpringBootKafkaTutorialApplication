package com.kafkaguide.springbootkafkatutorial.controllers;

import com.kafkaguide.springbootkafkatutorial.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    // http://localhost:8081/api/v1/kafka/publish?message=Hello World Spring for Kafka
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok(String.format("Message sent to the topic and data : %s",message));
    }
}
