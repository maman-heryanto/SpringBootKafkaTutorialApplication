package com.kafkaguide.springbootkafkatutorial.controllers;

import com.kafkaguide.springbootkafkatutorial.kafka.JsonKafkaProcedur;
import com.kafkaguide.springbootkafkatutorial.kafka.KafkaProducer;
import com.kafkaguide.springbootkafkatutorial.payload.User;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProcedur kafkaProcedur;

    public JsonMessageController(JsonKafkaProcedur kafkaProcedur) {
        this.kafkaProcedur = kafkaProcedur;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProcedur.sendMessage(user);
        return ResponseEntity.ok("Json Message send to kafka topic");
    }

}
