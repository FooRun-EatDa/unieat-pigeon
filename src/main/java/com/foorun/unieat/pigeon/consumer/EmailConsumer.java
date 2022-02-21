package com.foorun.unieat.pigeon.consumer;

import com.foorun.unieat.pigeon.domain.email.EmailPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailConsumer implements Consumer<EmailPayload> {
    private final JavaMailSender javaMailSender;

    @Override
    @EventListener
    public void consume(EmailPayload payload) {
        javaMailSender.send(payload);
    }
}
