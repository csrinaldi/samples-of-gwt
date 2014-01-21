/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.workingflow.gwt.client.ui.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.workingflow.gwt.client.ui.Home;

/**
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 */
public class HomeImpl implements Home {

    private static HomeImplUiBinder uiBinder = GWT.create(HomeImplUiBinder.class);

    interface HomeImplUiBinder extends UiBinder<Widget, HomeImpl> {
    }

    private Presenter presenter;
    private final Widget root;

    public HomeImpl() {
        root = uiBinder.createAndBindUi(this);
    }
    
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public Widget asWidget() {
        return root;
    }
}
