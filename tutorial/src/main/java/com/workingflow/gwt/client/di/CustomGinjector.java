/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.workingflow.gwt.client.di;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.workingflow.gwt.client.Bootstrap;

/**
 * Documentación de {@link CustomGinjector}.
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 *
 * Sectorial de Informática de Catastro
 */
@GinModules({AppModule.class, UiModule.class})
public interface CustomGinjector extends Ginjector {
    
    Bootstrap getBootstrap();
    
}
