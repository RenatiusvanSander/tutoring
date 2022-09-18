package com.remad.tutoring.dao;

import com.remad.tutoring.models.ServiceContract;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * service contract has all methods concerning CRUD-Repository
 */
public interface ServiceContractRepository extends JpaRepository<ServiceContract, Long> {

}
