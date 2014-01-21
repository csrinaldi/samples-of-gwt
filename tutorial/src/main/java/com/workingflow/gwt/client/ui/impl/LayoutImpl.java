package com.workingflow.gwt.client.ui.impl;

import com.github.gwtbootstrap.client.ui.Column;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.workingflow.gwt.client.ui.Layout;

/**
 * Documentation of {@link LayoutImpl}.
 *
 * Represent a Layout of Application.
 *
 * @author Cristian Rinaldi <csrinaldi@gmail.com>
 */
public class LayoutImpl implements Layout {
    
    private final static LayoutImplUiBinder uiBinder = GWT.create(LayoutImplUiBinder.class);
    
    interface LayoutImplUiBinder extends UiBinder<Widget, LayoutImpl> {
    }
    
    private final Widget root;
    
    @UiField
    SimplePanel regionUnit;
    @UiField
    SimplePanel regionContent;
    @UiField
    Column containerLeft;
    @UiField
    Column containerCenter;
    
    public LayoutImpl() {
        root = uiBinder.createAndBindUi(this);
    }
    
    public Widget asWidget() {
        return root;
    }
    
    public SimplePanel getUnitRegion() {
        return regionUnit;
    }
    
    public SimplePanel getContentRegion() {
        return regionContent;
    }
    
    public void maximiseCenter() {
        Window.alert("HOLA");
        containerLeft.setVisible(false);
        containerCenter.setVisible(true);
        containerLeft.setSize(0);
        containerLeft.setSize(12);
    }
    
}
