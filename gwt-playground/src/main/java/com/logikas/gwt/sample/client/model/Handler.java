/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.gwt.sample.client.model;

import com.logikas.gwt.sample.client.gwt_sample;

/**
 *
 * @author Cristian Rinaldi
 */
public class Handler implements gwt_sample.JsObject {

    private final String newValue;

    private final String oldValue;

    public Handler(String newValue, String oldValue) {
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public String getOldValue() {
        return oldValue;
    }
}
