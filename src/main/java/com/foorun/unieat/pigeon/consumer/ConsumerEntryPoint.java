package com.foorun.unieat.pigeon.consumer;

import com.foorun.unieat.pigeon.domain.Payload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ConsumerEntryPoint {
    @EventListener
    public void track(Payload payload) {
        log.info("convey events ==> {}", payload);
    }
}
