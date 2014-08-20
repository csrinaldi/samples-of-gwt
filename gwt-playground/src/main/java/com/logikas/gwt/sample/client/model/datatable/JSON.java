/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.gwt.sample.client.model.datatable;

import com.google.gwt.core.client.js.JsType;
import com.workingflows.js.jscore.client.api.JsObject;

/**
 * Interface of JSON object
 * @author Cristian Rinaldi
 */
@JsType(isNative = true, prototype = "JSON")
public interface JSON {
    String stringify(JsObject object);
}
