package com.logikas.samples.errai.client.local;

import com.google.common.base.Preconditions;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.logikas.samples.errai.client.mvp.presenter.configure.MVPInitializer;
import com.logikas.samples.errai.client.view.layout.MainLayout;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.EntryPoint;

/**
 * Description of App
 *
 * @author Cristian Rinaldi <csrinaldi@gmail.com>
 */
@EntryPoint
public class App {

    Button button = new Button("Activity");

    @Inject
    private MVPInitializer activityInitializer;
    
    @Inject
    private PlaceHistoryHandler placeHistoryHandler; 
            
           
    
    @Inject
    private MainLayout layout;

    @PostConstruct
    public void init() {
        RootLayoutPanel.get().add(layout.asWidget());
        activityInitializer = Preconditions.checkNotNull(activityInitializer, "MVP Initializer in NULL");
        activityInitializer.setDisplayRegions(layout);
        GWT.log("App initialized!!!");
        
        placeHistoryHandler = Preconditions.checkNotNull(placeHistoryHandler, "PlaceHistoryHandler is Null");
        placeHistoryHandler.handleCurrentHistory();
    }

    public void keyEventManager(@Observes KeyEvent e) {
        GWT.log("Event " + e.getSource().getClass().toString());
    }
}
