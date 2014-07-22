/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.gwt.sample.client.model;

import com.google.gwt.core.client.js.JsExport;
import com.google.gwt.core.client.js.JsNamespace;
import com.google.gwt.core.client.js.JsProperty;
import com.logikas.gwt.sample.client.gwt_sample;

/**
 *
 * @author Cristian Rinaldi
 */
@JsNamespace("$wnd.Logikas.Model")
public class Person implements gwt_sample.JsObject {

    private String name;

    @JsExport
    public Person() {
    }
    
    @JsExport
    public Person(String name) {
        this.name = name;
    }

    @JsProperty
    public String getName() {
        return name;
    }

    @JsProperty
    public void setName(String name) {
        this.name = name;
    }
    
    

}
