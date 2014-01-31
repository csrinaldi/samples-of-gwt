package com.logikas.mvp.server.locator;

import javax.inject.Inject;

import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class CustomServiceLocator implements ServiceLocator {

    private final Injector injector;

    @Inject
    CustomServiceLocator(Injector injector) {
        this.injector = injector;
    }

    @Override
    public Object getInstance(Class<?> clazz) {
        return injector.getInstance(clazz);
    }

}
