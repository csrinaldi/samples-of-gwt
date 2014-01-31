/**
 *
 */
package com.logikas.mvp.server.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.web.bindery.requestfactory.server.DefaultExceptionHandler;
import com.google.web.bindery.requestfactory.server.ExceptionHandler;

/**
 * Package: com.logikas.erp.server.ioc File: ErpMainModule.java Date: 27/09/2011
 *
 * @autor Cristian Rinaldi - Logikas Conectando Ideas
 *
 */
public class IocMainModule extends AbstractModule {

    /**
     * Configure the injection for all Application
     *
     * @see com.google.inject.AbstractModule#configure()
     */
    @Override
    protected void configure() {
        install(new JpaPersistModule("persistence-unit"));
        install(new IocJpaModule());
    }

    /**
     * Provides default implementation of {@link ExceptionHandler}
     *
     * @return {@link DefaultExceptionHandler}
     */
    @SuppressWarnings("unused")
    @Provides
    private ExceptionHandler getExceptionHandler() {
        return new DefaultExceptionHandler();
    }
}