/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.mvp.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

/**
 * Description of AddEmployeeEvent
 * Logikas. Conectando Ideas
 * @author Cristian Rinaldi
 */
public class AddEmployeeEvent extends GwtEvent<AddEmployeeEventHandler> {
  public static Type<AddEmployeeEventHandler> TYPE = new Type<AddEmployeeEventHandler>();
  
  @Override
  public Type<AddEmployeeEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(AddEmployeeEventHandler handler) {
    handler.onAddEmployee(this);
  }
}
