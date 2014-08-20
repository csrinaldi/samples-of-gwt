/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.gwt.sample.client.databinding;

import com.google.gwt.core.client.js.JsType;
import com.workingflows.js.jscore.client.api.JsObject;

/**
 *
 *
 * @author Cristian Rinaldi <a href="mailto:csrinaldi@gmail.com">csrinaldi@gmail.com</a>
 * 
 * Logikas
 * @param <T>
 * 
 */
@JsType(prototype = "ObjectObserver")
public interface ObjectObserver <T extends JsObject> extends Observable<T, T> {

}

