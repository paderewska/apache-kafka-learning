package com.learning.kafka.learning.controllers;

import com.learning.kafka.learning.engine.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    @Autowired
    private Producer producer;

    @GetMapping("/publish/{message}")
    public String post(@PathVariable("message") final String message) {
        producer.sendMessage(message);
        return "Published successfully";
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        producer.sendMessage(message);
    }

}
