package com.workingflow.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.workingflow.gwt.client.ui.Layout;
import com.workingflow.gwt.client.ui.impl.LayoutImpl;

public class Tutorial implements EntryPoint {

    public void onModuleLoad() {
        Layout layout = new LayoutImpl();
        RootPanel.get().add(layout);
    }
  
}
