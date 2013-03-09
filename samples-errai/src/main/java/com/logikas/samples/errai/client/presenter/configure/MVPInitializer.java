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
package com.logikas.samples.errai.client.presenter.configure;

import com.google.common.base.Preconditions;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.logikas.samples.errai.client.place.LoginPlace;
import com.logikas.samples.errai.client.presenter.LoginActivity;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/**
 *
 * @author cristian
 */
@Singleton
public class MVPInitializer {

    /*@Produces
    @Singleton
    public ActivityManager getCenterActivityManager(){
        GWT.log("AAAA");
        ActivityManager am = new ActivityManager(null, null);
        return am;
    }*/
    
    @Produces
    @Singleton
    public EventBus getEventBus(){
        return new SimpleEventBus();
    }
    
    @Produces
    @Singleton
    public PlaceController getPlaceController(EventBus eventBus){
        return new PlaceController(eventBus);
    }
    
    @Inject
    private Provider<CenterActivityMapper> actMapper;
    
    @Inject
    private Provider<EventBus> bus;
    
    //@Inject
    //private Provider<ActivityManager> centerActivitymanager;
    
    @Inject
    private Instance<ActivityManager> centerActivityManager;

    @PostConstruct
    private void init(){
        CenterActivityMapper am = Preconditions.checkNotNull(actMapper.get(), "CenterActivityMapper is Null");
        LoginActivity a = (LoginActivity) am.getActivity(new LoginPlace());
        a.start(null, null);
        
        //EventBus b = Preconditions.checkNotNull(bus.get(), "Event Buss is Null");
        ActivityManager actManager = Preconditions.checkNotNull(centerActivityManager.get(), "CenterActivityManager is Null");
        
        
    }
    
    
    
}
