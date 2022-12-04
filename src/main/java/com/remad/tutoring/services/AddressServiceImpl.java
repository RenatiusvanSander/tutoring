package com.remad.tutoring.services;

import com.remad.tutoring.dao.AddressRepository;
import com.remad.tutoring.models.Address;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 * Address service implementation of address service concerning create, delete, update, get single
 * and all addresses.
 */
@Service
public class AddressServiceImpl implements AddressService {

  /**
   * address repository for database and persistence operations
   */
  private final AddressRepository addressRepository;

  /**
   * Constructor
   *
   * @param addressRepository address repository for persistence and database access
   */
  public AddressServiceImpl(final AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  @Override
  public void createAddress(Address address) {
    if (!this.addressRepository.existsById(address.getId())) {
      this.addressRepository.saveAndFlush(address);
    }
  }

  @Override
  public void updateAddress(long id, Address address) {
    Address addressToUpdate = this.addressRepository.getReferenceById(id);

    if (!addressToUpdate.equals(address)) {
      addressToUpdate.setAddressHouseNo(address.getAddressHouseNo());
      addressToUpdate.setAddressStreet(address.getAddressStreet());

      this.addressRepository.saveAndFlush(addressToUpdate);
    }
  }

  @Override
  public void deleteAddress(long id) {
    this.addressRepository.deleteById(id);
  }

  @Override
  public Address getAddress(long id) {
    return this.addressRepository.getReferenceById(id);
  }

  @Override
  public Collection<Address> getsAddresses() {
    return this.addressRepository.findAll();
  }
}
