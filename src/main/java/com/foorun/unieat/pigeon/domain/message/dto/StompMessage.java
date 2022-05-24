package com.foorun.unieat.pigeon.domain.message.dto;

import com.foorun.unieat.pigeon.domain.message.jpo.MessageJpo;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StompMessage {
    private String content;
    private Long receiverMemberId;
    private boolean anonymous;

    public MessageJpo asJpo(long sender) {
        return MessageJpo.builder()
                .content(content)
                .sender(sender)
                .receiver(receiverMemberId)
                .anonymous(anonymous)
                .build();
    }
}
