/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.workingflow.gwt.client.ui;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.Div;

/**
 * Documentación de {@link Card}.
 *
 * @author Cristian Rinaldi <crinaldi@santafe.gov.ar>
 *
 * Sectorial de Informática de Catastro
 */
public class Card extends ComplexPanel implements Style.HasCssName {

    public enum CardType {

        DEFAULT,
        PEOPLE,
        PEOPLE_OVER;
    }

    private final String cssClass;

    public Card(CardType type) {
        cssClass = "card";
        switch (type) {
            case PEOPLE:
                addStyleName("people");
                break;
            case PEOPLE_OVER:
                addStyleName(cssClass);
                break;
            default:
                break;
        }
    }

    @Override
    protected void add(Widget child, Element container) {
        
    }
    
    

    public String getCssName() {
        return cssClass;
    }

}
