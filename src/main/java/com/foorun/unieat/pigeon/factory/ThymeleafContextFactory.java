package com.foorun.unieat.pigeon.factory;

import org.thymeleaf.context.Context;

import java.util.Locale;
import java.util.Map;

public class ThymeleafContextFactory {
    public static Context createDefault(Map<String, Object> variables) {
        return new Context(Locale.KOREA, variables);
    }
}
