package com.logiccache.dropwizard;

import com.logiccache.dropwizard.health.ExampleHealthCheck;
import com.logiccache.dropwizard.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class dropwizardExampleApplication extends Application<dropwizardExampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new dropwizardExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizardExample";
    }

    @Override
    public void initialize(final Bootstrap<dropwizardExampleConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final dropwizardExampleConfiguration configuration, final Environment environment) {
        final HelloResource resource = new HelloResource(configuration.getTemplate(), configuration.getDefaultName());
        final ExampleHealthCheck healthCheck = new ExampleHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
