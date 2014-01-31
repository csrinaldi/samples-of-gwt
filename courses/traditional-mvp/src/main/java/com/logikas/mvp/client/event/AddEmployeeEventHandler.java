/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.mvp.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Description of AddEmployeeEventHandler
 * Logikas. Conectando Ideas
 * @author Cristian Rinaldi
 */
public interface AddEmployeeEventHandler extends EventHandler{
    void onAddEmployee(AddEmployeeEvent event);
}
