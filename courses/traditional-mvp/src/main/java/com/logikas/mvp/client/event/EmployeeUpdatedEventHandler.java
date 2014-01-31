/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.mvp.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 *
 * @author scit232
 */
public interface EmployeeUpdatedEventHandler extends EventHandler{
    void onUpdatedEmployee(EmployeeUpdatedEvent event);
}
