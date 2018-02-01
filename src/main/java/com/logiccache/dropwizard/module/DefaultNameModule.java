package com.logiccache.dropwizard.module;

import com.logiccache.dropwizard.configuration.ExampleConfiguration;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class DefaultNameModule {

    private ExampleConfiguration configuration;

    public DefaultNameModule(ExampleConfiguration configuration) {
        this.configuration = configuration;
    }

    @Provides
    @Singleton
    @Named("defaultName")
    public String provideDefaultName() {
        return configuration.getDefaultName();
    }

}
