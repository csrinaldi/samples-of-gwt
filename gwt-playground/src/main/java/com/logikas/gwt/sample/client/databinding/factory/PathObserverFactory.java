/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.gwt.sample.client.databinding.factory;

import com.logikas.gwt.sample.client.databinding.ObjectObserver;
import com.logikas.gwt.sample.client.databinding.Observable;
import com.logikas.gwt.sample.client.databinding.PathObserver;
import com.logikas.gwt.sample.client.databinding.listener.ChangeFnListener;
import com.logikas.gwt.sample.client.databinding.listener.OpenObjectObserverListener;
import com.logikas.gwt.sample.client.databinding.listener.OpenPathObserverListener;
import com.workingflows.js.jscore.client.api.JsObject;



/**
 * {@link PathObserverFactory} is the component in charge of create all 
 * {@link ChangeFnListener} and {@link Observable} objects.
 * 
 * 
 * @author Cristian Rinaldi
 */
public class PathObserverFactory {

    public static native <T extends JsObject, E extends Object> PathObserver<T, E> createPathObserver(T obj, E path)/*-{
     return new $wnd.PathObserver(obj, path);
     }-*/;

    
    public static native <T extends JsObject> ObjectObserver<T> createObjectObserver(T obj)/*-{
     return new $wnd.ObjectObserver(obj);
     }-*/;
    
    public static native <T extends JsObject> OpenObjectObserverListener<T> createOpenObjectObserverListener(OpenObjectObserverListener<T> listener)/*-{
     return function(added, removed, changed, fn){
     listener.onOpen(added, removed, changed);
     }
     }-*/;
    
    public static native <T extends JsObject> OpenPathObserverListener<T> createOpenPathObserverListener(OpenPathObserverListener<T> listener)/*-{
     return function(newValue, oldValue){
     listener.onOpen(newValue, oldValue);
     }
     }-*/;
    
}
