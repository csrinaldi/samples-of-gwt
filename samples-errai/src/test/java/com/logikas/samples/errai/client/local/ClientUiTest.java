package com.logikas.samples.errai.client.local;

import org.jboss.errai.enterprise.client.jaxrs.test.AbstractErraiJaxrsTest;
import org.jboss.errai.ioc.client.Container;

import static org.junit.Assert.*;
import org.junit.Test;

import com.google.gwt.user.client.Timer;

public class ClientUiTest extends AbstractErraiJaxrsTest {

  @Override
  public String getModuleName() {
    return "com.logikas.samples.errai.App";
  }

  @Test
  public void testPopulateCustomersTable() {
    /*final App client = ErraiIocTestHelper.instance.client;

    new Timer() {
      @Override
      public void run() {
        if (client.rows.isEmpty()) {
          System.out.println("No data in the UI yet. Will check again later...");
          schedule(500);
          return;
        }

        // Assertions go here!
        assertEquals(3, client.rows.size());
        finishTest();
      }
    }.schedule(500);

    // allow the above polling mechanism 20 seconds to complete
    delayTestFinish(20000);*/
  }
}
