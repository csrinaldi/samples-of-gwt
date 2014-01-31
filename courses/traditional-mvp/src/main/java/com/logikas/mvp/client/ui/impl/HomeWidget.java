/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.mvp.client.ui.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.logikas.mvp.client.ui.HomeView;

/**
 *
 * @author Cristian Rinaldi
 */
public class HomeWidget implements HomeView {

    private static HomeWidgetUiBinder uiBinder = GWT.create(HomeWidgetUiBinder.class);

    interface HomeWidgetUiBinder extends UiBinder<HTMLPanel, HomeWidget> {
    }
    @UiField
    Button addButton;
    @UiField
    Button deleteButton;
    private HTMLPanel root;

    public HomeWidget() {
        root = uiBinder.createAndBindUi(this);
    }

    @Override
    public HasClickHandlers getAddButton() {
        return addButton;
    }

    @Override
    public HasClickHandlers getRemoveButton() {
        return deleteButton;
    }

    @Override
    public Widget asWidget() {
        return root;
    }
}
