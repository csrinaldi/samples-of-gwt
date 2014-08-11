/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.gwt.sample.client.model.datatable;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 *
 * @author Cristian Rinaldi
 */
@JsType
public interface DataTableElement {
    
    @JsProperty(value = "row")
    Row getRow();
    
    @JsProperty(value = "rows")
    Row getRows();

    DataTableElement draw();
    
    void nodes();
    
    Array data();
    
}
