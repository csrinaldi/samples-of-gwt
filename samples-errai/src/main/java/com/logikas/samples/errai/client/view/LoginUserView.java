/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.samples.errai.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * GWT Maven Archetype
 *
 * Documentation of Interface LoginUserView
 *
 *
 * Package: com.dinaru.client.view.impl 
 * Last modification: 12/01/2013
 * File: LoginUserView.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public interface LoginUserView extends IsWidget{
    
    public interface Presenter{
        
        void goTo(Place place);
        
        void login();
        
        void cancel();
        
    }

    void setPresenter( Presenter presenter );
    
    HasValue<String> getPassword();
    
    HasValue<String> getUsername();
    
    void showGlobalErrors(String error);
    
    //SimpleBeanEditorDriver<TokenUserProxy, ? extends Editor<TokenUserProxy>> createEditorDriver();

}
