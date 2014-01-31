package com.logikas.mvp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class TraditionalMVP implements EntryPoint{

    private HandlerManager eventBus;
	@Override
	public void onModuleLoad() {
            eventBus = new HandlerManager(null);
            AppController controller = new AppController(eventBus);
            controller.go(RootPanel.get());
	}

}
