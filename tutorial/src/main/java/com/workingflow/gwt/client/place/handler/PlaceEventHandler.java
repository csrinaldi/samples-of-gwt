/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.workingflow.gwt.client.place.handler;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.workingflow.gwt.client.place.HomePlace;
import com.workingflow.gwt.client.ui.Layout;

/**
 * Documentación de {@link PlaceEventHandler}.
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 *
 * Sectorial de Informática de Catastro
 */
public class PlaceEventHandler implements PlaceChangeEvent.Handler{

    private final Layout layout;
    private final PlaceController controller;
    private Place currentPlace = null;
    
    @Inject
    public PlaceEventHandler(PlaceController controller, Layout layout, EventBus eventBus) {
        this.layout = layout;
        this.controller = controller;
        eventBus.addHandler(PlaceChangeEvent.TYPE, this);
    }

    
    public void onPlaceChange(PlaceChangeEvent event) {
        
        Window.alert("event");
        
        if ( currentPlace != event.getNewPlace() ){
            if ( event.getNewPlace() instanceof HomePlace ){
                //Browser.getWindow().getConsole().log(event.getNewPlace());
                layout.maximiseCenter();
            }
            
            currentPlace = event.getNewPlace();
        }
    }

}
