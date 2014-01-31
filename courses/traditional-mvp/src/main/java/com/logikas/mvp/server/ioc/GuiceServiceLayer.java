package com.logikas.mvp.server.ioc;


import javax.persistence.EntityManager;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.web.bindery.requestfactory.server.ServiceLayer;
import com.google.web.bindery.requestfactory.server.ServiceLayerDecorator;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

/**
 * This is implementations of {@link ServiceLayer} using Guice
 * This will find the services associated with the {@link RequestContext}
 * 
 * @author Logikas - Connecting Ideas
 *
 */
@Singleton
public class GuiceServiceLayer extends ServiceLayerDecorator {

    private final Injector injector;

    @Inject
    public GuiceServiceLayer(Injector injector, Provider<EntityManager> em) {
        this.injector = injector;
    }

    @Override
    public <T extends Locator<?, ?>> T createLocator(Class<T> clazz) {
        return injector.getInstance(clazz);
    }

    @Override
    public Class<? extends Locator<?, ?>> resolveLocator(Class<?> domainType) {
        Class<? extends Locator<?, ?>> locator = super.resolveLocator(domainType);
        return locator;
    }

    @Override
    public Object createServiceInstance(
            Class<? extends RequestContext> requestContext) {

        Class<? extends ServiceLocator> locatorType = getTop().resolveServiceLocator(requestContext);
        // get guice supplied service locator
        ServiceLocator locator = injector.getInstance(locatorType);
        Class<?> serviceClass = getTop().resolveServiceClass(requestContext);
        return locator.getInstance(serviceClass);
    }
}
