package com.logiccache.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Strings;
import com.logiccache.dropwizard.api.Saying;
import javax.inject.Inject;
import javax.inject.Named;

public class HelloResource implements HelloApi {

    private String template;
    private String defaultName;

    @Inject
    public HelloResource(@Named("defaultName") String defaultName, @Named("template") String template) {
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
