/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.gwt.sample.client.databinding.factory;

import com.logikas.gwt.sample.client.databinding.PathObserver;
import com.logikas.gwt.sample.client.databinding.listener.OpenPathObserverListener;
import com.logikas.gwt.sample.client.gwt_sample;

/**
 *
 * @author Cristian Rinaldi
 */
public class PathObserverFactory {

    public static native <T extends gwt_sample.JsObject, E extends Object> PathObserver<T, E> createObserver(T obj, E path)/*-{
     return new $wnd.PathObserver(obj, path);
     }-*/;

    public static native <T extends gwt_sample.JsObject> OpenPathObserverListener<T> createOpenPathObserverListener(OpenPathObserverListener<T> listener)/*-{
     return function(oldValue, newValue){
     listener.onOpen(oldValue, newValue);
     }
     }-*/;
}
