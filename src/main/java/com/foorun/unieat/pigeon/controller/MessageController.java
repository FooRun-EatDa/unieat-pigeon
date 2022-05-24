package com.foorun.unieat.pigeon.controller;

import com.foorun.unieat.pigeon.domain.message.dto.StompMessage;
import com.foorun.unieat.pigeon.domain.message.jpo.MessageJpo;
import com.foorun.unieat.pigeon.domain.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageRepository messageRepository;

    @MessageMapping("/one-to-one")
    public void oneToOne(@Payload Message<StompMessage> message, StompHeaderAccessor stompHeaderAccessor) {
        StompMessage stompMessage = message.getPayload();
        MessageJpo messageJpo = stompMessage.asJpo(getHeaderSenderId(stompHeaderAccessor));
        messageRepository.save(messageJpo);
        simpMessagingTemplate.convertAndSend(String.format("/user/queue/message/%d", stompMessage.getReceiverMemberId()), message.getPayload());
    }

    private long getHeaderSenderId(StompHeaderAccessor stompHeaderAccessor) {
        return Objects.requireNonNull(stompHeaderAccessor.getNativeHeader("X-SENDER-ID"))
                .stream()
                .map(Long::parseLong)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
