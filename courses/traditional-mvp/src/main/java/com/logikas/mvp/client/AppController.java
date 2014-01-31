package com.logikas.mvp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.logikas.mvp.client.event.AddEmployeeEvent;
import com.logikas.mvp.client.event.AddEmployeeEventHandler;
import com.logikas.mvp.client.event.EmployeeUpdatedEvent;
import com.logikas.mvp.client.event.EmployeeUpdatedEventHandler;
import com.logikas.mvp.client.presenter.AddEmployeePresenter;
import com.logikas.mvp.client.presenter.HomePresenter;
import com.logikas.mvp.client.presenter.Presenter;
import com.logikas.mvp.client.ui.AddEmployeeView;
import com.logikas.mvp.client.ui.HomeView;
import com.logikas.mvp.client.ui.impl.AddEmployeeWidget;
import com.logikas.mvp.client.ui.impl.HomeWidget;

/**
 * Description of AppController Logikas. Conectando Ideas
 *
 * @author Cristian Rinaldi
 */
public class AppController implements Presenter, ValueChangeHandler<String> {

    private final HandlerManager eventBus;
    private HasWidgets container;
    private HomeView homeView;
    private AddEmployeeView addEmployeeView;
    private MVPServiceAsync services;

    public AppController(HandlerManager eventBus) {
        this.eventBus = eventBus;
        this.services = GWT.create(MVPService.class);
        bind();
    }

    public HandlerManager getEventBus() {
        return eventBus;
    }

    @Override
    public void go(HasWidgets container) {
        this.container = container;

        if ("".equals(History.getToken())) {
            History.newItem("home");
        } else {
            History.fireCurrentHistoryState();
        }
    }

    @Override
    public void bind() {
        History.addValueChangeHandler(this);

        eventBus.addHandler(AddEmployeeEvent.TYPE, new AddEmployeeEventHandler() {
            @Override
            public void onAddEmployee(AddEmployeeEvent event) {
                doAddEmployee();
            }
        });

        eventBus.addHandler(EmployeeUpdatedEvent.TYPE, new EmployeeUpdatedEventHandler() {
            @Override
            public void onUpdatedEmployee(EmployeeUpdatedEvent event) {
                doUploadedEmployee();
            }
        });
    }

    private void doUploadedEmployee() {
        History.newItem("home");
    }

    private void doAddEmployee() {
        History.newItem("addEmployee");
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        String token = event.getValue();

        if (token != null) {
            if (token.equals("addEmployee")) {
                GWT.runAsync(new RunAsyncCallback() {

                    @Override
                    public void onFailure(Throwable caught) {
                    }

                    @Override
                    public void onSuccess() {

                        if (addEmployeeView == null) {
                            addEmployeeView = new AddEmployeeWidget();
                        }

                        AddEmployeePresenter presenter = new AddEmployeePresenter(addEmployeeView, eventBus, services);
                        addEmployeeView.setPresenter(presenter);
                        presenter.go(container);
                    }
                });
            } else if (token.equals("home")) {
                GWT.runAsync(new RunAsyncCallback() {

                    @Override
                    public void onFailure(Throwable caught) {
                    }

                    @Override
                    public void onSuccess() {
                        // lazily initialize our views, and keep them around to be reused
                        //
                        if (homeView == null) {
                            homeView = new HomeWidget();
                        }

                        new HomePresenter(homeView, eventBus).go(container);

                    }
                });
            }
        }
    }
}
