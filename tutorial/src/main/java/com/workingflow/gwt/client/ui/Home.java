/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.workingflow.gwt.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.workingflow.gwt.client.place.NavigationPresenter;

/**
 * Documentación de {@link Home}.
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 *
 * Sectorial de Informática de Catastro
 */
public interface Home extends IsWidget{

    interface Presenter extends NavigationPresenter{
        
    }
    
    void setPresenter(Presenter presenter);
    
    
}

