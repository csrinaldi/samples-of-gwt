/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.gwt.sample.client.model.event;

import com.logikas.gwt.sample.client.gwt_sample;

/**
 *
 * @author devuser
 */

public interface ChangeEvent extends gwt_sample.JsObject{
    
    String getName();
    
    gwt_sample.JsObject getObject();
    
    String getType();
    
}
