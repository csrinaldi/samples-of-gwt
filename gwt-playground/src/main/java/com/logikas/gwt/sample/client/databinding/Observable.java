/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.gwt.sample.client.databinding;

import com.google.gwt.core.client.js.JsType;
import com.logikas.gwt.sample.client.databinding.listener.ChangeFnListener;
import com.logikas.gwt.sample.client.gwt_sample;

/**
 *
 *
 * @author Cristian Rinaldi <a
 * href="mailto:csrinaldi@gmail.com">csrinaldi@gmail.com</a>
 * @param <T>
 * @param <E>
 *
 *
 */
@JsType
public interface Observable<T extends gwt_sample.JsObject, E extends Object> extends gwt_sample.JsObject {

    void close();

    <L extends ChangeFnListener<T>> E open(L change, T target);

    void deliver();

    String discardChanges();
}
