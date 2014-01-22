/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.workingflow.gwt.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.workingflow.gwt.client.place.HomePlace;
import com.workingflow.gwt.client.place.handler.PlaceEventHandler;
import com.workingflow.gwt.client.ui.Layout;
import javax.inject.Named;

/**
 * Documentación de {@link BootstrapImpl}.
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 *
 * Sectorial de Informática de Catastro
 */
@Singleton
public class BootstrapImpl implements Bootstrap {

    private final Layout mainLayout;
    
    private final PlaceHistoryHandler historyHandler;
    
    private final ActivityManager activityManager;
    
    private final PlaceController controller;

    @Inject
    BootstrapImpl(PlaceHistoryHandler historyHandler, 
            Layout mainLayout,
            ActivityManager manager,
            PlaceEventHandler handler, 
            PlaceController controller) {
        this.historyHandler = historyHandler;
        this.mainLayout = mainLayout;
        this.activityManager = manager;
        this.controller = controller;
    }

    @Override
    public void start() {
        activityManager.setDisplay(mainLayout.getContentRegion());
        //RootLayoutPanel.get().add(mainLayout.asWidget());
        //controller.goTo(new HomePlace());
        
    }

}
