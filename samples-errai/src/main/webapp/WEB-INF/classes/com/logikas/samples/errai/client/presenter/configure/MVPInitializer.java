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

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

/**
 * Description of MVPInitializer
 * @author Cristian Rinaldi <csrinaldi@gmail.com>
 */
@Singleton
@Dependent
public class MVPInitializer {
   
    @Produces
    @Singleton
    public EventBus getEventBus(){
        return new SimpleEventBus();
    }

    @PostConstruct
    private void init(){
        
    }
    
}
