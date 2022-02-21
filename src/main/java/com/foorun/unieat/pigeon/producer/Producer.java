package com.foorun.unieat.pigeon.producer;

import com.foorun.unieat.pigeon.domain.Payload;

import java.util.Collections;
import java.util.List;

public interface Producer<T extends Payload> {
    void produce(List<T> payloads);

    default void produce(T payload) {
        produce(Collections.singletonList(payload));
    }
}
