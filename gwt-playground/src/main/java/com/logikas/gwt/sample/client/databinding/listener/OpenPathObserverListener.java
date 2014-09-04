/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.gwt.sample.client.databinding.listener;

import com.google.gwt.core.client.js.JsType;
import com.logikas.gwt.sample.client.databinding.PathObserver;
import com.workingflows.js.jscore.client.api.JsObject;


/**
 *  {@link OpenPathObserverListener} is a listener for open event in 
 * the {@link PathObserver}
 *
 * @author Cristian Rinaldi <a
 * href="mailto:csrinaldi@gmail.com">csrinaldi@gmail.com</a>
 *
 * Logikas
 * @param <T>
 *
 */
@JsType
public interface OpenPathObserverListener<T extends JsObject> extends ChangeFnListener<T> {
    /**
     * @param newValue
     * @param oldValue 
     */
    void onOpen(String newValue, String oldValue);
}
