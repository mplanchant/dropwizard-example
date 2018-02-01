package com.logiccache.dropwizard.module;

import com.logiccache.dropwizard.configuration.ExampleConfiguration;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class TemplateModule {

    private ExampleConfiguration configuration;

    public TemplateModule(ExampleConfiguration configuration) {
        this.configuration = configuration;
    }

    @Provides
    @Singleton
    @Named("template")
    public String provideTemplate() {
        return configuration.getTemplate();
    }

}
