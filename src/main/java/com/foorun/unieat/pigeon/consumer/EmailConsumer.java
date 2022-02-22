package com.foorun.unieat.pigeon.consumer;

import com.foorun.unieat.pigeon.domain.MimeMessageBuilder;
import com.foorun.unieat.pigeon.domain.email.EmailPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
@RequiredArgsConstructor
public class EmailConsumer implements Consumer<EmailPayload> {
    private final JavaMailSender javaMailSender;
    private final MimeMessageBuilder mimeMessageBuilder;

    @Override
    @EventListener
    public void consume(EmailPayload payload) {
        if (payload.isUseTemplate()) {
            MimeMessage mimeMessage = mimeMessageBuilder.builder()
                    .payload(payload)
                    .build();
            javaMailSender.send(mimeMessage);
        } else {
            javaMailSender.send(payload);
        }
    }
}
