/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.gwt.sample.client.model;

/**
 *
 * @author devuser
 * @param <E>
 */
public interface Handler<E extends Object> {
    
    void handle(E event);

}
