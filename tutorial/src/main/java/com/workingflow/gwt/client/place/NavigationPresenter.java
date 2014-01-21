/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.workingflow.gwt.client.place;

import com.google.gwt.place.shared.Place;

/**
 * Documentación de {@link NavigationPresenter}.
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 *
 * Sectorial de Informática de Catastro
 */
public interface NavigationPresenter {

    void go(NavigationPresenter presenter);
    
    void setPlace(Place place);
    
}
