package com.logiccache.dropwizard.component;


import com.logiccache.dropwizard.module.DefaultNameModule;
import com.logiccache.dropwizard.module.TemplateModule;
import com.logiccache.dropwizard.resources.HelloResource;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DefaultNameModule.class, TemplateModule.class})
public interface  ExampleComponent {
    HelloResource inject();
}