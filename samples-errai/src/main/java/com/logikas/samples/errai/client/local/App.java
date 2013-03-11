package com.logikas.samples.errai.client.local;

import com.google.common.base.Preconditions;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import org.jboss.errai.ioc.client.api.EntryPoint;

/**
 * Description of App
 *
 * @author Cristian Rinaldi <csrinaldi@gmail.com>
 */
@EntryPoint
public class App {

    @Produces
    @Singleton
    private EventBus produceMyBean() {
        return new SimpleEventBus();
    }
    
    @Inject
    private Provider<EventBus> eventBus;

    @PostConstruct
    public void init() {
        EventBus eb = Preconditions.checkNotNull(eventBus.get(), "EventBus is null");
        GWT.log(eb.toString());
    }

    public void keyEventManager(@Observes KeyEvent e) {
        GWT.log("Event " + e.getSource().getClass().toString());
    }
}