/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.gwt.sample.client.model.event;

import com.logikas.gwt.sample.client.gwt_sample;
import com.workingflows.js.jscore.client.api.JsObject;

/**
 *
 * @author devuser
 */

public interface ChangeEvent extends JsObject{
    
    String getName();
    
    JsObject getObject();
    
    String getType();
    
}
