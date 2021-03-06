/*
 * Copyright 2013 JBoss, a division of Red Hat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.logikas.samples.errai.client.mvp.presenter.configure;

import com.google.common.base.Preconditions;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.logikas.samples.errai.client.mvp.place.LoginPlace;
import com.logikas.samples.errai.client.place.configure.AppPlaceHistoryMapper;
import com.logikas.samples.errai.client.view.layout.MainLayout;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Description of MVPInitializer
 *
 * @author Cristian Rinaldi <csrinaldi@gmail.com>
 */
@ApplicationScoped
public class MVPInitializer {

    @Inject
    private EventBus bus;
    @Inject
    private PlaceController controller;
    @Inject
    private CenterActivityMapper centerMapper;
    @Inject
    private PopupActivityMapper popupMapper;
    @Inject
    @CenterRegion
    private ActivityManager centerActivityManager;
    //@Inject
    //@PopupRegion
    //private ActivityManager popupActivityManager;
    @Inject
    private PlaceHistoryHandler historyHandler;
    @Inject
    private PlaceHistoryMapper historyMapper;
    
    //@Inject
    //private MainLayout layout;

    @Produces
    @Singleton
    public PlaceHistoryHandler getHistoryHandler() {
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(controller, bus, new LoginPlace());
        return historyHandler;
    }

    @Produces
    @Singleton
    public EventBus getEventBus() {
        return new SimpleEventBus();
    }

    @Produces
    @Singleton
    public PlaceHistoryMapper getHistoryMapper() {
        return new AppPlaceHistoryMapper();
    }

    @Produces
    @Singleton
    public PlaceController getPlaceController(EventBus eventBus) {
        return new PlaceController(eventBus);
    }

    @Produces
    @Singleton
    @CenterRegion
    public ActivityManager getCenterActivityManager() {
        return new ActivityManager(centerMapper, bus);
    }

    /*@Produces
    @Singleton
    @PopupRegion
    public ActivityManager getPopupActivityManager() {
        return new ActivityManager(popupMapper, bus);
    }*/

    @PostConstruct
    private void init() {
        EventBus b = Preconditions.checkNotNull(bus, "Event Buss is Null");
        GWT.log(b.toString());

        PlaceController c = Preconditions.checkNotNull(controller, "PlaceController is Null");
        GWT.log(c.getWhere().toString());

        centerActivityManager = Preconditions.checkNotNull(centerActivityManager, "Center ActivityManager is Null");
        GWT.log(centerActivityManager.getClass().toString()+" Injected");
        //cam.setDisplay(layout.getCenterReqion());
        
        //ActivityManager pam = Preconditions.checkNotNull(popupActivityManager, "Popup ActivityManager is Null");
        //GWT.log(pam.getClass().toString()+" Injected");
        //pam.setDisplay(layout.getPopupRegion());
        
        //MainLayout ml = Preconditions.checkNotNull(layout, "Layout is Null");
        //GWT.log(ml.getClass().toString()+" Injected");
    }
    
    public void setDisplayRegions(MainLayout layout){
          MainLayout l = Preconditions.checkNotNull(layout, "Popup ActivityManager is Null");
          centerActivityManager.setDisplay(layout.getCenterReqion());
          
    }
}
