/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.gwt.sample.client;

import com.logikas.gwt.sample.client.gwt_sample.EventListener;

/**
 *
 *
 * @author Andres Testi <a
 * href="mailto:andres.a.testi@gmail.com">andres.a.testi@gmail.com</a>
 * @author Cristian Rinaldi <a
 * href="mailto:csrinaldi@gmail.com">csrinaldi@gmail.com</a>
 *
 * WorkingFlows
 *
 */
public class EventListenerFactory {

    public static native gwt_sample.EventListener createEventListener(EventListener listener)/*-{
     return function(evt){
     listener.onEvent(evt);
     }
     }-*/;

}
