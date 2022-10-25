package com.remad.tutoring.controllers;

import com.remad.tutoring.models.ServiceContract;
import com.remad.tutoring.services.ServiceContractService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

/**
 * Controller concerning action of service contract. Means delete, create, get and update.
 */
@RequestMapping("/service-contracts")
@Controller
public class ServiceContractController {

  /**
   * service contract service to access service contracts
   */
  @Autowired
  private final ServiceContractService serviceContractService;

  /**
   * Constructor
   *
   * @param serviceContractService service contract service to update, delete, create and get
   *                               {@link ServiceContract}
   */
  public ServiceContractController(final ServiceContractService serviceContractService) {
    this.serviceContractService = serviceContractService;
  }

  /**
   * Gets all service contracts
   *
   * @return returns all service contracts. When no one is existing on database when empty.
   */
  @GetMapping("/get-all")
  @ResponseBody
  public ResponseEntity<Collection<ServiceContract>> getAllServiceContracts() {
    Collection<ServiceContract> serviceContracts =
        this.serviceContractService.getAllServiceContracts();

    return ResponseEntity.ok(serviceContracts);
  }

  /**
   * Gets service contracts
   *
   * @param id service contract's identifier to load service contract for
   * @return the loaded service contract. Otherwise empty;
   */
  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity<ServiceContract> getServiceContract(long id) {
    try {
      ServiceContract contract = this.serviceContractService.getServiceContract(id);

      return contract != null ? ResponseEntity.ok(contract) : ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
          "Cannot load the service contract.",
          e);
    }
  }

  /**
   * Creates service contract
   *
   * @param serviceContract the service contract to create
   * @return Responses with a HTTP Status 200, when created. Otherwise HTTP status 500 internal
   * server error.
   */
  @PostMapping("/create-service-contract")
  @ResponseBody
  public ResponseEntity<Object> createServiceContract(ServiceContract serviceContract) {
    try {
      this.serviceContractService.createServiceContract(serviceContract);

      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
          "Cannot create the service contract.",
          e);
    }
  }

  /**
   * Deletes service contract
   *
   * @param id service contract's identifer to delete service contract for
   * @return Responses with a HTTP Status 200, when created. Otherwise HTTP status 500 internal
   * server error.
   */
  @DeleteMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Object> deleteServiceContract(@PathVariable long id) {
    try {
      this.serviceContractService.deleteServiceContract(id);

      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
          "Cannot delete the service contract.",
          e);
    }
  }

  /**
   * Updates service contract
   *
   * @param id              service contract's identifier to load service contract to update
   * @param serviceContract updated service contract data
   * @return Responses HTTP Status 200, when updated. Otherwise http status 500 internal server
   * error
   */
  @PutMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Object> updateServiceContract(long id, ServiceContract serviceContract) {
    try {
      this.serviceContractService.updateServiceContract(id, serviceContract);

      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
          "Cannot update the service contract.",
          e);
    }
  }
}
