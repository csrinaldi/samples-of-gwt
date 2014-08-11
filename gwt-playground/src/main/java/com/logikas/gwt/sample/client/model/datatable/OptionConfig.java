/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.gwt.sample.client.model.datatable;

import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.js.JsProperty;
import java.util.ArrayList;

/**
 * Configuration of Datatable
 * @author Cristian Rinaldi
 */
public interface OptionConfig {
    
    @JsProperty(value = "lrtip")
    String getDom();
    
    void setDom(String dom);
    
    @JsProperty( value = "[]")
    ArrayList<JsArrayString> getData();
    
    @JsProperty
    void setData(ArrayList<JsArrayString> data);

    @JsProperty(value = "[]")
    ArrayList<ColumnConfig> getColumns();

    @JsProperty
    void setColumns(ArrayList<ColumnConfig> columns);

    @JsProperty
    ArrayList lengthMenu();

    @JsProperty
    int getPageLength();
    
    @JsProperty
    void setPageLength(int length);

    @JsProperty( value = "full_numbers")
    String getPagingType();
    
    void setPagingType(String type);
    
    @JsProperty
    void setOrdering(boolean ordering);
    
    @JsProperty
    boolean getOrdering();
    
    @JsProperty
    void setSearching(boolean searching);
    
    @JsProperty
    boolean getSearching();
    
    @JsProperty
    void setInfo(boolean info);
    
    @JsProperty
    boolean getInfo();
    
    
    
    
}
