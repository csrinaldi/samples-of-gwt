package com.logikas.samples.gwt.cellwidget.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class cellwidget implements EntryPoint {
  

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
      CwCustomDataGrid ccdg = new CwCustomDataGrid(null);
      Widget wc = ccdg.onInitialize();
      RootLayoutPanel.get().add(wc);
  }
  
}
