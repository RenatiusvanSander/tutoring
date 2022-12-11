package com.remad.tutoring.controllers;

import com.remad.tutoring.models.Customer;
import com.remad.tutoring.services.CustomerService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for customer concerning actions like get, delete, get all, update
 */
@Controller
@RequestMapping("/customers")
public class CustomerController {

  /**
   * customer service to access customers
   */
  @Autowired
  private final CustomerService customerService;

  /**
   * Constructor
   *
   * @param customerService customer service to access customers
   */
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  /**
   * Creates customer
   *
   * @param customerToCreate given customer to create
   * @return response with HTTP status 200, 2h3n customer created.
   */
  @PostMapping("/create-customer")
  @ResponseBody
  public ResponseEntity<Object> createCustomer(@RequestBody Customer customerToCreate) {
    this.customerService.createCustomer(customerToCreate);

    return ResponseEntity.ok().build();
  }

  /**
   * Gets all customers
   *
   * @return Case of the database has customer the response is status HTTP-status 200 and the body
   * contains the customers as collection. Otherwise the response has HTTP-Status 500 for internal
   * server errors.
   */
  @GetMapping("/get-all-customers")
  @ResponseBody
  public ResponseEntity<Collection<Customer>> getAllCustomers() {
    Collection<Customer> customers = this.customerService.getAllCustomers();

    return customers.isEmpty() ? ResponseEntity.internalServerError().build()
        : ResponseEntity.ok(customers);
  }

  /**
   * Updates customer.
   *
   * @param id               numeric identifier of customer to update
   * @param customerToUpdate the updated customer data
   * @return Case of customer has been updated the response is status HTTP-status 200. Otherwise the
   * response has HTTP-Status 500 for internal server errors.
   */
  @PutMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Object> updateCustomer(@PathVariable long id,
      @RequestBody Customer customerToUpdate) {
    this.customerService.updateCustomer(id, customerToUpdate);

    return ResponseEntity.ok().build();
  }

  /**
   * Deletes a customer.
   *
   * @param id numeric identifier of customer to delete
   * @return Case of customer has been deleted the response is status HTTP-status 200. Otherwise the
   * response has HTTP-Status 500 for internal server errors.
   */
  @DeleteMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Object> deleteCustomer(@PathVariable long id) {
    this.customerService.deleteCustomer(id);

    return ResponseEntity.ok().build();
  }

  /**
   * Gets customer.
   *
   * @param id numeric customer identifier to get customer data
   * @return
   */
  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
    return ResponseEntity.ok(this.customerService.getCustomer(id));
  }
}
