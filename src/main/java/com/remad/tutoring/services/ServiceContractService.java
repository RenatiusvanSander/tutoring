package com.remad.tutoring.services;

import com.remad.tutoring.models.ServiceContract;
import java.util.Collection;

/**
 * service contract service interface for service contracts. This declares methods fro create,
 * delete, update, get and get all service contracts.
 */
public interface ServiceContractService {

  /**
   * Creates service contract
   *
   * @param serviceContract given service contract to create
   */
  void createServiceContract(ServiceContract serviceContract);

  /**
   * Deletes service contract.
   *
   * @param id given numeric service contract identifier to delete for
   */
  void deleteServiceContract(long id);

  /**
   * Updates service contract.
   *
   * @param id              given numeric service contract identifier to update service contract
   * @param serviceContract given service contract with updated data
   */
  void updateServiceContract(long id, ServiceContract serviceContract);

  /**
   * Gets service contract
   *
   * @param id service contract's numeric identifier to get service contract for
   * @return found service contract
   */
  ServiceContract getServiceContract(long id);

  /**
   * Gets all service contract
   *
   * @return returns all service contract from database
   */
  Collection<ServiceContract> getAllServiceContracts();
}
