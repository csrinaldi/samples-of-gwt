/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.workingflow.gwt.client.di;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.workingflow.gwt.client.ui.Home;
import com.workingflow.gwt.client.ui.Layout;
import com.workingflow.gwt.client.ui.impl.HomeImpl;
import com.workingflow.gwt.client.ui.impl.LayoutImpl;

/**
 * Documentación de {@link UiModule}.
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 *
 * Sectorial de Informática de Catastro
 */
public class UiModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(Layout.class).to(LayoutImpl.class).in(Singleton.class);
        bind(Home.class).to(HomeImpl.class).in(Singleton.class);
        
    }

}
