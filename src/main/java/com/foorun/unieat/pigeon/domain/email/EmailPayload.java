package com.foorun.unieat.pigeon.domain.email;

import com.foorun.unieat.pigeon.domain.Payload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

@Getter
@Setter
@ToString(callSuper = true)
public class EmailPayload extends SimpleMailMessage implements Payload {
    @Override
    public void setFrom(String from) {
        super.setFrom(from);
    }

    @Override
    public String getFrom() {
        return super.getFrom();
    }

    @Override
    public void setReplyTo(String replyTo) {
        super.setReplyTo(replyTo);
    }

    @Override
    public String getReplyTo() {
        return super.getReplyTo();
    }

    @Override
    public void setTo(String to) {
        super.setTo(to);
    }

    @Override
    public void setTo(String... to) {
        super.setTo(to);
    }

    @Override
    public String[] getTo() {
        return super.getTo();
    }

    @Override
    public void setCc(String cc) {
        super.setCc(cc);
    }

    @Override
    public void setCc(String... cc) {
        super.setCc(cc);
    }

    @Override
    public String[] getCc() {
        return super.getCc();
    }

    @Override
    public void setBcc(String bcc) {
        super.setBcc(bcc);
    }

    @Override
    public void setBcc(String... bcc) {
        super.setBcc(bcc);
    }

    @Override
    public String[] getBcc() {
        return super.getBcc();
    }

    @Override
    public void setSentDate(Date sentDate) {
        super.setSentDate(sentDate);
    }

    @Override
    public Date getSentDate() {
        return super.getSentDate();
    }

    @Override
    public void setSubject(String subject) {
        super.setSubject(subject);
    }

    @Override
    public String getSubject() {
        return super.getSubject();
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    @Override
    public String getText() {
        return super.getText();
    }
}
