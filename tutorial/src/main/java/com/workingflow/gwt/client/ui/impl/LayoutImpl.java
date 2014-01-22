package com.workingflow.gwt.client.ui.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.workingflow.gwt.client.ui.Layout;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Navbar;
import org.gwtbootstrap3.client.ui.NavbarForm;
import org.gwtbootstrap3.client.ui.TextBox;


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
    
    SimplePanel regionUnit;
    SimplePanel regionContent;
    Column containerLeft;
    Column containerCenter;
    
    //@UiField
    TextBox user;
    
    //@UiField
    TextBox password;
    
    //@UiField
    Button login;
    
    Navbar navbar;
    
    NavbarForm form;
    
    public LayoutImpl() {
        root = uiBinder.createAndBindUi(this);
        //form.se
        //navbar.setPosition(NavbarPosition.FIXED_TOP);
        //login.setType(ButtonType.PRIMARY);
        /*user.addStyleName("span2");
        user.setAlignment(ValueBoxBase.TextAlignment.RIGHT);
        password.addStyleName("span2");
        password.setAlignment(ValueBoxBase.TextAlignment.RIGHT);
        //login.addStyleName("pull-right");*/
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
        
    }
    
}
