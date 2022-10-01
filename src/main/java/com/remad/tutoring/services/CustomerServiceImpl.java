package com.remad.tutoring.services;

import com.remad.tutoring.dao.CustomerRepository;
import com.remad.tutoring.models.Address;
import com.remad.tutoring.models.Customer;
import java.util.Collection;

/**
 * Implementation of {@link CustomerService} concerning create, delete, update, gets single and all
 * customers
 */
public class CustomerServiceImpl implements CustomerService {

  /**
   * the zip code service
   */
  private final ZipCodeService zipCodeService;

  /**
   * the address service
   */
  private final AddressService addressService;

  /**
   * customer repository for database and persistence operations
   */
  private final CustomerRepository customerRepository;

  /**
   * Constructor
   *
   * @param zipCodeService     zip code service
   * @param addressService     address service
   * @param customerRepository customer repository for database and persistence operations
   */
  public CustomerServiceImpl(final ZipCodeService zipCodeService,
      final AddressService addressService, final CustomerRepository customerRepository) {
    this.zipCodeService = zipCodeService;
    this.addressService = addressService;
    this.customerRepository = customerRepository;
  }

  @Override
  public void createCustomer(Customer customer) {
    this.zipCodeService.create(customer.getCustomerZipCode());
    this.addressService.createAddress(customer.getCustomerAddress());
    this.customerRepository.saveAndFlush(customer);
  }

  @Override
  public void deleteCustomer(long id) {
    Customer customer = this.customerRepository.getReferenceById(id);
    addressService.deleteAddress(customer.getCustomerAddress().getId());
    customerRepository.delete(customer);
  }

  @Override
  public void updateCustomer(long id, Customer customer) {
    Customer customerToUpdate = this.customerRepository.getReferenceById(id);

    if (customerToUpdate.getCustomerNo() > 0) {
      Address addressToUpdate = customerToUpdate.getCustomerAddress();
      this.addressService.updateAddress(addressToUpdate.getId(), customer.getCustomerAddress());

      this.zipCodeService.create(customer.getCustomerZipCode());
      this.customerRepository.saveAndFlush(customer);
    }
  }

  @Override
  public Customer getCustomer(long id) {
    return this.customerRepository.getReferenceById(id);
  }

  @Override
  public Collection<Customer> getAllCustomers() {
    return this.customerRepository.findAll();
  }
}
