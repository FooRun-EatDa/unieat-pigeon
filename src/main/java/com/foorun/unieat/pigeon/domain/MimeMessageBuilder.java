package com.foorun.unieat.pigeon.domain;

import com.foorun.unieat.pigeon.domain.email.EmailPayload;
import com.foorun.unieat.pigeon.factory.ThymeleafContextFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;

import static java.util.Objects.requireNonNull;

@Component
@RequiredArgsConstructor
public class MimeMessageBuilder {
    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine springTemplateEngine;

    public PayloadBuilder builder() {
        return new PayloadBuilder();
    }

    protected MimeMessage createMimeMessage() {
        return javaMailSender.createMimeMessage();
    }

    public class PayloadBuilder {
        private EmailPayload emailPayload;

        public PayloadBuilder payload(EmailPayload emailPayload) {
            this.emailPayload = emailPayload;
            return this;
        }

        public MimeMessage build() {
            try {
                MimeMessage mimeMessage = createMimeMessage();
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
                if (StringUtils.hasText(emailPayload.getFrom())) {
                    messageHelper.setFrom(emailPayload.getFrom());
                }
                messageHelper.setTo(requireNonNull(emailPayload.getTo()));
                messageHelper.setSubject(requireNonNull(emailPayload.getSubject()));
                messageHelper.setText(springTemplateEngine
                        .process(emailPayload.getTemplateName(), ThymeleafContextFactory.createDefault(emailPayload.getProperties())), true);
                return mimeMessage;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
