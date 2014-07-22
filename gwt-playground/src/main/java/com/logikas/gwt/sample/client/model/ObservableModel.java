/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.gwt.sample.client.model;

import com.logikas.gwt.sample.client.gwt_sample;

/**
 *
 * @author devuser
 */
public class ObservableModel implements gwt_sample.JsObject{

    public static void observe(gwt_sample.JsObject obj, Handler<?> callback){
        gwt_sample.window().getConsole().log(obj, "");
    }
    
}
