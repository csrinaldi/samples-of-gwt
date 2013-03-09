package com.logikas.samples.errai.client.local;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.Container;
import org.jboss.errai.ioc.client.api.EntryPoint;

import com.google.gwt.core.client.GWT;

/**
 * This class provides a target for injecting parts of the application that the
 * test cases need access to. Think of it as your test suite's window into the
 * IoC container. Test cases can access the injected members using the following
 * code:
 *
 * <pre>
 *   ErraiIocTestHelper.instance.<i>injectedFieldName</i>
 * </pre>
 * <p>
 * Note that this "IoC Test Helper" pattern is just a workaround. If there were
 * something like the BeanManager available in the client, it would be
 * preferable for the tests to create and destroy managed beans on demand.
 * <p>
 * As an alternative workaround, you could dispense with this class altogether
 * and have your main Entry Point class keep a static reference to itself.
 * However, this would pollute the API with an unwanted singleton pattern: there
 * would be the possibility of classes referring to the entry point class through
 * its singleton rather than allowing it to be injected.
 *
 * @author Jonathan Fuerth <jfuerth@gmail.com>
 */
@EntryPoint
public class ErraiIocTestHelper {

  static ErraiIocTestHelper instance;

  @Inject App client;

  @PostConstruct
  public void tryMe() {
    instance = this;
    System.out.println("ErraiIocTestHelper postconstruct");
  }

}
