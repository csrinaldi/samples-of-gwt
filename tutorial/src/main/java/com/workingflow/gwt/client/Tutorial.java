package com.workingflow.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.workingflow.gwt.client.di.CustomGinjector;

public class Tutorial implements EntryPoint {

    private final CustomGinjector injector = GWT.create(CustomGinjector.class);
    
    public void onModuleLoad() {
        injector.getBootstrap().start();
    }
  
}
