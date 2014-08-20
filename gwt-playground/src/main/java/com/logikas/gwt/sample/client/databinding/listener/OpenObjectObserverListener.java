/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.gwt.sample.client.databinding.listener;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.js.JsType;
import com.logikas.gwt.sample.client.databinding.ObjectObserver;
import com.workingflows.js.jscore.client.api.JsObject;



/**
 *  {@link OpenObjectObserverListener} is a listener for open event in 
 * the {@link ObjectObserver}
 *
 * @author Cristian Rinaldi <a
 * href="mailto:csrinaldi@gmail.com">csrinaldi@gmail.com</a>
 *
 * Logikas
 * @param <T>
 *
 */
@JsType
public interface OpenObjectObserverListener<T extends JsObject> extends ChangeFnListener<T> {

    /**
     * 
     * @param added
     * @param removed
     * @param changed 
     * @param fn 
     */
    void onOpen(JsArray added, JsArray removed, JsArray changed);

}
