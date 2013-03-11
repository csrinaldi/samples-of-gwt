package com.logikas.samples.errai.client.local;

import com.google.common.base.Preconditions;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.EntryPoint;

import com.logikas.samples.errai.client.presenter.configure.MVPInitializer;
import javax.inject.Provider;

/**
 * Example code showing how to use Errai-JAXRS.
 *
 * @author Christian Sadilek <csadilek@redhat.com>
 */
@EntryPoint
public class App {

    Button button = new Button("Activity");

    @Inject
    private MVPInitializer activityInitializer;

    @PostConstruct
    public void init() {
        
        //ActivityManager a = Preconditions.checkNotNull(am.get(), "CenterActivityManager is Null");
        
        RootPanel.get().add(button);
        button.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
            }
        });
    }
}