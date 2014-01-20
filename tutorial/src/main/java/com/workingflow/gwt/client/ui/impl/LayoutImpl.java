package com.workingflow.gwt.client.ui.impl;

import com.github.gwtbootstrap.client.ui.Container;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
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

    //@UiField
    Container regionUnit;

    //@UiField
    Container regionContent;

    public LayoutImpl() {
        root = uiBinder.createAndBindUi(this);
    }

    public Widget asWidget() {
        return root;
    }

    public Container getUnitRegion() {
        return regionUnit;
    }

    public Container getContentRegion() {
        return regionContent;
    }

}
