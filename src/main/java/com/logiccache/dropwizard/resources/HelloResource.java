package com.logiccache.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Strings;
import com.logiccache.dropwizard.api.Saying;

public class HelloResource implements HelloApi {
    private final String template;
    private final String defaultName;

    public HelloResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
    }

    @Timed
    @Override
    public Saying getHello(String name) {
        final String value = String.format(template, Strings.isNullOrEmpty(name) ? defaultName : name);
        return new Saying().id(1).content(value);
    }
}
