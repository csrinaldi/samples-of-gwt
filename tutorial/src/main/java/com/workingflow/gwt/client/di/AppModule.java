/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.workingflow.gwt.client.di;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.workingflow.gwt.client.Bootstrap;
import com.workingflow.gwt.client.BootstrapImpl;
import com.workingflow.gwt.client.activity.CenterActivityMapper;
import com.workingflow.gwt.client.place.AppPlaceHistoryMapper;
import com.workingflow.gwt.client.place.HomePlace;
import com.workingflow.gwt.client.ui.Layout;

/**
 * Documentación de {@link AppModule}.
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 *
 * Sectorial de Informática de Catastro
 */
public class AppModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

        bind(PlaceHistoryMapper.class).to(AppPlaceHistoryMapper.class).in(Singleton.class);

        bind(Bootstrap.class).to(BootstrapImpl.class).in(Singleton.class);

        bind(CenterActivityMapper.class).in(Singleton.class);
    }

    /**
     * Creates a new PlaceHistoryHandler. This object is responsible handling
     * navigation based on the browser URL. You only need one of those for the
     * entire app.
     *
     * @param placeController the place controller.
     * @param historyMapper This is used to map the URL to a Place object and
     * vice versa.
     * @param eventBus the event bus.
     * @return
     */
    @SuppressWarnings("deprecation")
    @Provides
    @Singleton
    public PlaceHistoryHandler getHistoryHandler(PlaceController placeController,
            PlaceHistoryMapper historyMapper, EventBus eventBus) {

        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, new HomePlace());
        return historyHandler;
    }

    /**
     * Creates a new PlaceController. The place controller is used by the
     * PlaceHistoryHandler and activities to tell the app to navigate to a
     * different place. You only need one for the entire app. However, it is
     * essential for it to get instantiated in order for the application
     * navigation to work.
     *
     * @param eventBus the event bus.
     * @return
     */
    @SuppressWarnings("deprecation")
    @Provides
    @Singleton
    public PlaceController getPlaceController(EventBus eventBus) {
        return new PlaceController(eventBus);
    }
    

    @Provides
    @Singleton
    public ActivityManager getPlaceController(CenterActivityMapper mapper, Layout layout, EventBus eventBus) {
        ActivityManager manager = new ActivityManager(mapper, eventBus);
        return manager;
    }
    
    
}
