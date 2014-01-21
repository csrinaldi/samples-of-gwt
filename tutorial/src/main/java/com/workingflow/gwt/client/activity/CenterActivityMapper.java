/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.workingflow.gwt.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.workingflow.gwt.client.place.HomePlace;

/**
 * Documentación de {@link CenterActivityMapper}.
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 *
 * Sectorial de Informática de Catastro
 */
public class CenterActivityMapper implements ActivityMapper{

    private final Provider<HomeActivity> homeActivity;
    
    @Inject
    public CenterActivityMapper(Provider<HomeActivity> homeActivity) {
        this.homeActivity = homeActivity;
    }
    
    public Activity getActivity(Place place) {
        if (place instanceof HomePlace){
            HomeActivity home = homeActivity.get();
            home.setPlace(place);
            return home;
        }
        return null;
    }

}
