/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.mvp.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

/**
 *
 * @author scit232
 */
public class EmployeeUpdatedEvent extends GwtEvent<EmployeeUpdatedEventHandler> {
  public static Type<EmployeeUpdatedEventHandler> TYPE = new Type<EmployeeUpdatedEventHandler>();
  
  @Override
  public Type<EmployeeUpdatedEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(EmployeeUpdatedEventHandler handler) {
    handler.onUpdatedEmployee(this);
  }
}
