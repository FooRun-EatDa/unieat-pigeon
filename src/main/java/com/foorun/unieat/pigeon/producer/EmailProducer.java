package com.foorun.unieat.pigeon.producer;

import com.foorun.unieat.pigeon.domain.email.EmailPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmailProducer implements Producer<EmailPayload> {
    private final ApplicationEventPublisher publisher;

    @Override
    public void produce(List<EmailPayload> payloads) {
        payloads.forEach(publisher::publishEvent);
    }
}
