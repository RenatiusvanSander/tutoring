package com.remad.tutoring.dao;

import com.remad.tutoring.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Customer repository has all methods concerning CRUD-repository
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
