/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.workingflow.gwt.client.resources;

import com.google.gwt.resources.client.CssResource;

/**
 * Documentación de {@link BootplusStyle}.
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 *
 * Sectorial de Informática de Catastro
 */
public interface BootplusStyle extends CssResource{

    String DEFAULT_CSS = "com/workingflow/gwt/client/resources/bootplus.css";
    
    /** Generals */
    @ClassName("lgk-fieldset")
    String fieldset();
    
}
