/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.gwt.sample.client.databinding.listener;

import com.google.gwt.core.client.js.JsType;
import com.logikas.gwt.sample.client.databinding.Observable;
import com.workingflows.js.jscore.client.api.JsObject;


/**
 * {@link ChangeFnListener} is a general listener for open method in the all
 * {@link Observable} objects.
 *
 * @author Cristian Rinaldi <a
 * href="mailto:csrinaldi@gmail.com">csrinaldi@gmail.com</a>
 *
 * Logikas
 * @param <T>
 *
 */
@JsType
public interface ChangeFnListener<T extends JsObject> {}
