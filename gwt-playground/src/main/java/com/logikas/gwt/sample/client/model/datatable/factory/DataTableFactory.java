/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.gwt.sample.client.model.datatable.factory;

import com.logikas.gwt.sample.client.model.datatable.Array;
import com.logikas.gwt.sample.client.model.datatable.ColumnConfig;
import com.logikas.gwt.sample.client.model.datatable.OptionConfig;

/**
 *
 * @author Cristian Rinaldi
 */
public class DataTableFactory {
    
    public static native OptionConfig createDataTableConfig() /*-{
     return {};
     }-*/;

    public static native ColumnConfig createColumnConfig() /*-{
     return {};
     }-*/;
    
    public static native Array createArray() /*-{
     return new Array();
     }-*/;
    
}
