package com.remad.tutoring.services;

import com.remad.tutoring.models.Address;
import java.util.Collection;

/**
 * address service interface concerning create, update, delete, get single and get all addresses.
 */
public interface AddressService {

  /**
   * Creates address
   *
   * @param address given address to create on database
   */
  void createAddress(Address address);

  /**
   * Updates address.
   *
   * @param id
   * @param address
   */
  void updateAddress(long id, Address address);

  /**
   * Deletes address.
   *
   * @param id address's numeric identifier to delete address
   */
  void deleteAddress(long id);

  /**
   * Gets single address.
   *
   * @param id address's numeric identifier to get address for
   * @return found address by id
   */
  Address getAddress(long id);

  /**
   * Gets all addresses
   *
   * @return all addresses stored on database
   */
  Collection<Address> getsAddresses();
}
