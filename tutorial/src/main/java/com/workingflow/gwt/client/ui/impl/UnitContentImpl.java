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
public class UnitContentImpl extends Composite {
    
    private static UnitContentImplUiBinder uiBinder = GWT.create(UnitContentImplUiBinder.class);
    
    interface UnitContentImplUiBinder extends UiBinder<Widget, UnitContentImpl> {
    }
    
    public UnitContentImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
