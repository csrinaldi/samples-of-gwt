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
public class PathObserverFactory{
    
    public static native gwt_sample.PathObserver createObserver(gwt_sample.JsObject obj, String path)/*-{
            return new $wnd.PathObserver(obj, path);
    }-*/;
    
    
}
