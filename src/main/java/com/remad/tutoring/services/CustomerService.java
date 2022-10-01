package com.remad.tutoring.services;

import com.remad.tutoring.models.Customer;
import java.util.Collection;

/**
 * service for customer concerning creating, deleting, updating, getting single and all customers.
 */
public interface CustomerService {

  /**
   * Creates customer.
   *
   * @param customer given customer to create
   */
  void createCustomer(Customer customer);

  /**
   * Deletes customer.
   *
   * @param id customer's numeric identifier to delete customer
   */
  void deleteCustomer(long id);

  /**
   * Updates customer.
   *
   * @param id       customer's numeric identifier to update
   * @param customer update customer's data
   */
  void updateCustomer(long id, Customer customer);

  /**
   * Gets single customer.
   *
   * @param id customer's numeric id to get
   * @return customer matching the identifier
   */
  Customer getCustomer(long id);

  /**
   * Gets all customers
   *
   * @return all customers from database
   */
  Collection<Customer> getAllCustomers();
}
