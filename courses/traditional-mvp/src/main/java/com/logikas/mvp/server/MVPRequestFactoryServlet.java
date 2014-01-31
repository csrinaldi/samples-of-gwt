package com.logikas.mvp.server;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.web.bindery.requestfactory.server.ExceptionHandler;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.logikas.mvp.server.ioc.GuiceServiceLayer;

@Singleton
public class MVPRequestFactoryServlet extends RequestFactoryServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    MVPRequestFactoryServlet(ExceptionHandler exceptionHandler, GuiceServiceLayer guiceServiceLayer) {
        super(exceptionHandler, guiceServiceLayer);
    }

}
