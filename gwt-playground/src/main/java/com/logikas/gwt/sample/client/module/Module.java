/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.gwt.sample.client.module;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * Interface for Modules definition
 *
 * @author Cristian Rinaldi <a
 * href="mailto:csrinaldi@gmail.com">csrinaldi@gmail.com</a>
 *
 * Logikas
 *
 */
@JsType
public interface Module {

    @JsProperty
    String getName();

    @JsProperty
    String getVersion();

}
