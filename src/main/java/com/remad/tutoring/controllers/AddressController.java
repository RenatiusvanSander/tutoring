package com.remad.tutoring.controllers;

import com.remad.tutoring.models.Address;
import com.remad.tutoring.services.AddressService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller concerning deleting, creating, validating and getting all addresses.
 */
@Controller
@RequestMapping("/addresses")
public class AddressController {

  /**
   * address service for creating, deleting and updating address data sets
   */
  @Autowired
  private final AddressService addressService;

  /**
   * Constructor
   *
   * @param addressService address service for creating, deleting, updating an address
   */
  public AddressController(AddressService addressService) {
    this.addressService = addressService;
  }

  /**
   * Gets all addresses
   *
   * @return json encoded addresses
   */
  @GetMapping("/all")
  @ResponseBody
  public ResponseEntity<Collection<Address>> getAddresses() {
    Collection<Address> addresses = this.addressService.getsAddresses();

    return ResponseEntity.ok(addresses);
  }

  /**
   * Gets address by REST
   *
   * @param id the address's identifier to get address for
   * @return the matching address for identifier
   */
  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Address> getAddress(@PathVariable long id) {
    Address address = this.addressService.getAddress(id);

    return ResponseEntity.ok(address);
  }

  /**
   * Deletes an address
   *
   * @param id address's identifier to delete matching address
   * @return Returns status ok.
   */
  @DeleteMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Object> deleteAddress(@PathVariable long id) {
    this.addressService.deleteAddress(id);

    return ResponseEntity.ok().build();
  }
}
