package com.foorun.unieat.pigeon.controller;

import com.foorun.unieat.pigeon.producer.EmailProducer;
import com.foorun.unieat.pigeon.domain.email.EmailPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/email", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EmailController {
    private final EmailProducer emailProducer;

    @PostMapping("/single")
    public void post(@RequestBody EmailPayload payload) {
        emailProducer.produce(payload);
    }

    @PostMapping("/multi")
    public void post(@RequestBody List<EmailPayload> payload) {
        emailProducer.produce(payload);
    }
}
