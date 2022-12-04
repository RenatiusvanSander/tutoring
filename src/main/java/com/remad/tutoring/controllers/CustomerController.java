package com.remad.tutoring.controllers;

import com.remad.tutoring.models.Customer;
import com.remad.tutoring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
  @RequestMapping("/create-customer")
  @ResponseBody
  public ResponseEntity<Object> createCustomer(@RequestBody Customer customerToCreate) {
    this.customerService.createCustomer(customerToCreate);

    return ResponseEntity.ok().build();
  }
}
