/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.gwt.sample.client.model.datatable;

/**
 *
 * @author Cristian Rinaldi
 */
public class JsFactory {
    
    /**
     * Create a native JSON object of Javascript
     * @return 
     */
    public static native JSON createJSON() /*-{
     return JSON;
     }-*/;
    
}
