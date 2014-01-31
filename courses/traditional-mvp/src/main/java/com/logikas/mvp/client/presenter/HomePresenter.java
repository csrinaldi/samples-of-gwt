/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.mvp.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.logikas.mvp.client.event.AddEmployeeEvent;

/**
 * Description of HomePresenter
 * Logikas. Conectando Ideas
 * @author Cristian Rinaldi
 */
public class HomePresenter implements Presenter{

    @Override
    public void bind() {
        this.display.getAddButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new AddEmployeeEvent());
            }
        });
    }

    public interface Display extends IsWidget{
        HasClickHandlers getAddButton();
        HasClickHandlers getRemoveButton();
    }
    
    Display display;
    private HandlerManager eventBus;

    public HomePresenter(Display display, HandlerManager eventBus) {
        this.display = display;
        this.eventBus = eventBus;
        bind();
    }
    
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }

}
