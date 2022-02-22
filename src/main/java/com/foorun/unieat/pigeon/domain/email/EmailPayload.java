package com.foorun.unieat.pigeon.domain.email;

import com.foorun.unieat.pigeon.domain.Payload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@ToString(callSuper = true)
public class EmailPayload extends SimpleMailMessage implements Payload {
    /**
     * 별도의 HTML 템플릿 사용 여부
     */
    private boolean useTemplate = false;

    /**
     * 사용할 이메일 템플릿명(디렉토리를 포함한 HTML 파일 경로)<br />
     * ex) ${RESOURCE_SERVER_HOST}/${RESOURCE_SERVER_BASE_URI}/email/verification-email.html 일 경우<br />
     *  Template Resolver 설정의 Prefix, Suffix 를 제외한 --> email/verification-email
     */
    private String templateName;

    /**
     * 이메일 템플릿에 Binding 할 파라미터
     */
    private Map<String, Object> properties;

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
