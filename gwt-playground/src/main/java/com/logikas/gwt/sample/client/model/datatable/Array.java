/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.gwt.sample.client.model.datatable;

import com.logikas.gwt.sample.client.model.JsObject;
import com.google.gwt.core.client.js.JsType;

/**
 *
 * @author Cristian Rinaldi
 * @param <T>
 */
@JsType(prototype = "Array")
public interface Array extends JsObject{
    
    void push(Object data);
    
}
