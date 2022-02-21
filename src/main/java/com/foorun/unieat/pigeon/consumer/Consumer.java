package com.foorun.unieat.pigeon.consumer;

public interface Consumer<T> {
    void consume(T t);
}
