package com.remad.tutoring.models;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Store data concerning the service contract we and customer committed and is part of invoice.
 */
@Entity
public class ServiceContract {

  /**
   * Gets service contract number
   *
   * @return service contract's number
   */
  public long getServiceContractNo() {
    return serviceContractNo;
  }

  /**
   * Sets service contract number
   *
   * @param serviceContractNo service contract number to set as primary key AND Identifier
   */
  public void setServiceContractNo(long serviceContractNo) {
    this.serviceContractNo = serviceContractNo;
  }

  /**
   * Gets service contract name
   *
   * @return service contract's name
   */
  public String getServiceContractName() {
    return serviceContractName;
  }

  /**
   * Sets name.
   *
   * @param serviceContractName service contract's name to set
   */
  public void setServiceContractName(String serviceContractName) {
    this.serviceContractName = serviceContractName;
  }

  /**
   * Gets service contract's escription
   *
   * @return service contract's description
   */
  public String getServiceContractDescription() {
    return serviceContractDescription;
  }

  /**
   * Sets service contract description
   *
   * @param serviceContractDescription service contract's description to set
   */
  public void setServiceContractDescription(String serviceContractDescription) {
    this.serviceContractDescription = serviceContractDescription;
  }

  /**
   * Gets service contract cration date
   *
   * @return service contract's create date
   */
  public LocalDateTime getServiceContractCreationDate() {
    return serviceContractCreationDate;
  }

  /**
   * Sets service contract creation dte
   *
   * @param serviceContractCreationDate service contract's creation date to set
   */
  public void setServiceContractCreationDate(LocalDateTime serviceContractCreationDate) {
    this.serviceContractCreationDate = serviceContractCreationDate;
  }

  @Override
  public String toString() {
    return "ServiceContract{" +
        "serviceContractNo=" + serviceContractNo +
        ", serviceContractName='" + serviceContractName + '\'' +
        ", serviceContractDescription='" + serviceContractDescription + '\'' +
        ", serviceContractCreationDate=" + serviceContractCreationDate +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ServiceContract)) {
      return false;
    }
    ServiceContract that = (ServiceContract) o;
    return serviceContractNo == that.serviceContractNo && serviceContractName.equals(
        that.serviceContractName) && serviceContractDescription.equals(
        that.serviceContractDescription) && serviceContractCreationDate.equals(
        that.serviceContractCreationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceContractNo, serviceContractName, serviceContractDescription,
        serviceContractCreationDate);
  }

  /**
   * Constructor
   */
  public ServiceContract() {
  }

  /**
   * Constructor
   *
   * @param serviceContractNo           service contract number used as primary key
   * @param serviceContractName         given service contract name
   * @param serviceContractDescription  given service contract description
   * @param serviceContractCreationDate creation date of service contract
   */
  public ServiceContract(long serviceContractNo, String serviceContractName,
      String serviceContractDescription, LocalDateTime serviceContractCreationDate) {
  }

  /**
   * service contract number as primary key
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long serviceContractNo;

  /**
   * name of service contract
   */
  private String serviceContractName;

  /**
   * description of service contract
   */
  private String serviceContractDescription;

  /**
   * creation date of service contract
   */
  private LocalDateTime serviceContractCreationDate;
}