/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.workingflow.gwt.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.workingflow.gwt.client.place.NavigationPresenter;
import com.workingflow.gwt.client.ui.Home;

/**
 * Documentación de {@link HomeActivity}.
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 *
 * Sectorial de Informática de Catastro
 */
public class HomeActivity extends AbstractActivity implements Home.Presenter {

    private Place place;

    private AsyncProvider<Home> homeView;

    @Inject
    public HomeActivity(AsyncProvider<Home> homeView) {
        this.homeView = homeView;
    }

    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        homeView.get(new AsyncCallback<Home>() {

            public void onSuccess(Home result) {
                panel.setWidget(result);
                prepareView(result);
            }

            public void onFailure(Throwable caught) {
                //TODO error
            }

        });
    }
    
    private void prepareView(Home view){
        view.setPresenter(this);
    }

    public void go(NavigationPresenter presenter) {

    }

    public void setPlace(Place place) {
        this.place = place;
    }

}
