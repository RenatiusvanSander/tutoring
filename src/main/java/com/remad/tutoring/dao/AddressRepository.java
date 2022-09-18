package com.remad.tutoring.dao;

import com.remad.tutoring.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Address repository has all methods concerning a crud-repository
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

}
