package com.logikas.samples.errai.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.logikas.samples.errai.client.shared.Customer;
import com.logikas.samples.errai.client.shared.CustomerService;

/**
 * Simple mock based service implementation.
 * 
 * @author Christian Sadilek <csadilek@redhat.com>
 */
public class CustomerServiceImpl implements CustomerService {

  private static AtomicInteger id = new AtomicInteger(3);
  
  private static Map<Long, Customer> customers = new ConcurrentHashMap<Long, Customer>() {
    {
      put(1l, new Customer(1, "Christian", "Sadilek", "A1B2C3"));
      put(2l, new Customer(2, "Mike", "Brock", "A1B2C3"));
      put(3l, new Customer(3, "Jonathan", "Fuerth", "A1B2C3"));
    }
  };

  @Override
  public long createCustomer(Customer customer) {
    customer.setId(id.incrementAndGet());
    customers.put(customer.getId(), customer);
    return customer.getId();
  }

  @Override
  public Customer updateCustomer(long id, Customer customer) {
    customers.put(id, customer);
    customer.setLastChanged(new Date());
    return customer;
  }

  @Override
  public void deleteCustomer(long id) {
    customers.remove(id);
  }

  @Override
  public Customer retrieveCustomerById(long id) {
    return customers.get(id);
  }

  @Override
  public List<Customer> listAllCustomers() {
    List<Customer> customers = new ArrayList<Customer>(CustomerServiceImpl.customers.values());
    Collections.sort(customers);
    return customers;
  }
}