/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.workingflow.gwt.client.ui.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 */
public class UnitListImpl extends Composite {
    
    private static UnitListImplUiBinder uiBinder = GWT.create(UnitListImplUiBinder.class);
    
    interface UnitListImplUiBinder extends UiBinder<Widget, UnitListImpl> {
    }
    
    public UnitListImpl() {
        initWidget(uiBinder.createAndBindUi(this));

    }
}
