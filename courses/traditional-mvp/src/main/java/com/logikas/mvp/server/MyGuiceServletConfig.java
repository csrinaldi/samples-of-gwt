package com.logikas.mvp.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.logikas.mvp.server.ioc.IocServletModule;

public class MyGuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new IocServletModule());
    }
}