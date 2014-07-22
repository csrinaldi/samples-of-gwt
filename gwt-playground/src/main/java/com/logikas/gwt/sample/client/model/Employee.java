/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.gwt.sample.client.model;

import com.google.gwt.core.client.js.JsExport;

/**
 *
 * @author devuser
 */
public class Employee extends Person {
    
    /**
     * Social identification for {@link Employee}
     */
    private String cuit;
    
    @JsExport
    public Employee(String name, String cuit){
        super(name);
        this.cuit = cuit;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

}
