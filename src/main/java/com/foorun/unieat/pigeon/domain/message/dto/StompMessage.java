package com.foorun.unieat.pigeon.domain.message.dto;

import com.foorun.unieat.pigeon.domain.message.jpo.MessageJpo;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StompMessage {
    private String content;
    private Long receiverMemberId;
    private boolean anonymous;
    private LocalDateTime createdAt = LocalDateTime.now();

    public MessageJpo asJpo(long sender) {
        return MessageJpo.builder()
                .content(content)
                .sender(sender)
                .createdAt(createdAt)
                .receiver(receiverMemberId)
                .anonymous(anonymous)
                .build();
    }
}
