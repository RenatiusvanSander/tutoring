package com.remad.tutoring.services;

import com.remad.tutoring.dao.ServiceContractRepository;
import com.remad.tutoring.models.ServiceContract;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 * Implementation of service contract service, which has methods for deleting, creating, getting and
 * getting all service contracts.
 */
@Service
public class ServiceContractServiceImpl implements ServiceContractService {

  /**
   * service contract repository for database and persistence operations.
   */
  private final ServiceContractRepository serviceContractRepository;

  /**
   * Constructor
   *
   * @param serviceContractRepository service contract repository for database and persistence
   *                                  operations
   */
  public ServiceContractServiceImpl(final ServiceContractRepository serviceContractRepository) {
    this.serviceContractRepository = serviceContractRepository;
  }

  @Override
  public void createServiceContract(ServiceContract serviceContract) {
    this.serviceContractRepository.saveAndFlush(serviceContract);
  }

  @Override
  public void deleteServiceContract(long id) {
    this.serviceContractRepository.deleteById(id);
  }

  @Override
  public void updateServiceContract(long id, ServiceContract serviceContract) {
    ServiceContract serviceContractToUpdate = this.serviceContractRepository.getReferenceById(id);

    if (!serviceContractToUpdate.equals(serviceContract)) {
      serviceContractToUpdate.setServiceContractDescription(
          serviceContract.getServiceContractDescription());
      serviceContractToUpdate.setServiceContractName(serviceContract.getServiceContractName());
      serviceContractToUpdate.setServiceContractCreationDate(
          serviceContract.getServiceContractCreationDate());

      this.serviceContractRepository.saveAndFlush(serviceContractToUpdate);
    }
  }

  @Override
  public ServiceContract getServiceContract(long id) {
    return this.serviceContractRepository.getReferenceById(id);
  }

  @Override
  public Collection<ServiceContract> getAllServiceContracts() {
    return this.serviceContractRepository.findAll();
  }
}
