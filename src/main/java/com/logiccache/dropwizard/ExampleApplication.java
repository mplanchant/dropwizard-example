package com.logiccache.dropwizard;

import com.logiccache.dropwizard.component.DaggerExampleComponent;
import com.logiccache.dropwizard.component.ExampleComponent;
import com.logiccache.dropwizard.configuration.ExampleConfiguration;
import com.logiccache.dropwizard.health.ExampleHealthCheck;
import com.logiccache.dropwizard.module.DefaultNameModule;
import com.logiccache.dropwizard.module.TemplateModule;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class ExampleApplication extends Application<ExampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizardExample";
    }

    @Override
    public void initialize(final Bootstrap<ExampleConfiguration> bootstrap) {
    }

    @Override
    public void run(final ExampleConfiguration configuration, final Environment environment) {

        final ExampleHealthCheck healthCheck = new ExampleHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);

        environment.jersey().register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(configuration.getDefaultName()).to(String.class);
            }
        });

        final ExampleComponent component = DaggerExampleComponent.builder()
                .defaultNameModule(new DefaultNameModule(configuration))
                .templateModule(new TemplateModule(configuration))
                .build();

        environment.jersey().register(component.inject());
    }
}
