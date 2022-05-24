package com.foorun.unieat.pigeon.domain.message.jpo;

import lombok.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "message")
public class MessageJpo implements Persistable<Long> {
    @Id
    @Builder.Default
    private Long no = 0L;

    @Column(name = "send_member_id")
    private Long sender;

    @Column(name = "receive_member_id")
    private Long receiver;

    @Column(name = "content")
    private String content;

    @Column(name = "is_anonymous")
    private boolean anonymous;

    @Builder.Default
    @Column(name = "is_read")
    private boolean read = false;

    private LocalDateTime createdAt;

    @Override
    public Long getId() {
        return this.no;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
