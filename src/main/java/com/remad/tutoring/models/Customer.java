package com.remad.tutoring.models;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * all functions concerning a customer like storing data ofr name, address, birthdate, e-mail, phone
 * number and creation date of data set
 */
@Entity
@Table(name = "Customer")
public class Customer {

  /**
   * customer's numbers, is a primary key for data base.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "customer_no")
  private long customerNo;

  /**
   * customer's first name, for example Herbert.
   */
  private String customerFirstName;

  /**
   * customer's lastname
   */
  private String customerLastName;

  /**
   * customer's birthday
   */
  @Column(name = "customer_birthday", columnDefinition = "TIMESTAMP")
  private LocalDateTime customerBirthday;
  /**
   * customer's street
   */
  private String customerStreet;

  /**
   * customer's house number
   */
  private String customerHouseNo;
  /**
   * customer's zip code
   */

  @OneToOne
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address customerAddress;

  /**
   * customer's phone number
   */
  private String customerTelephoneNo;

  /**
   * customer's e-mail
   */
  private String customerEmail;

  /**
   * customer's creation date
   */
  @Column(name = "customer_creation_date", columnDefinition = "TIMESTAMP")
  private LocalDateTime customerCreationDate;

  /**
   * Constructor
   */
  public Customer() {
  }

  /**
   * Customer
   *
   * @param customerFirstName   customer's first name
   * @param customerLastName    customer's last name
   * @param customerBirthday    customer's birthday
   * @param customerStreet      customer's street
   * @param customerHouseNo     customer's house number
   * @param customerAddress     customer's address
   * @param customerTelephoneNo customer's telephone number
   */
  public Customer(String customerFirstName, String customerLastName,
      LocalDateTime customerBirthday, String customerStreet, String customerHouseNo,
      Address customerAddress, String customerTelephoneNo) {
    this.customerFirstName = customerFirstName;
    this.customerLastName = customerLastName;
    this.customerBirthday = customerBirthday;
    this.customerStreet = customerStreet;
    this.customerHouseNo = customerHouseNo;
    this.customerAddress = customerAddress;
    this.customerTelephoneNo = customerTelephoneNo;
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerNo, customerFirstName, customerLastName, customerBirthday,
        customerStreet, customerHouseNo, customerAddress, customerTelephoneNo, customerEmail,
        customerCreationDate);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Customer)) {
      return false;
    }
    Customer customer = (Customer) o;
    return customerNo == customer.customerNo && customerAddress == customer.customerAddress
        && customerFirstName.equals(customer.customerFirstName) && customerLastName.equals(
        customer.customerLastName) && customerBirthday.equals(customer.customerBirthday)
        && customerStreet.equals(customer.customerStreet) && customerHouseNo.equals(
        customer.customerHouseNo) && customerTelephoneNo.equals(customer.customerTelephoneNo)
        && customerEmail.equals(customer.customerEmail) && customerCreationDate.equals(
        customer.customerCreationDate);
  }

  @Override
  public String toString() {
    return "Customer{" +
        "customerNo=" + customerNo +
        ", customerFirstName='" + customerFirstName + '\'' +
        ", customerLastName='" + customerLastName + '\'' +
        ", customerBirthday=" + customerBirthday +
        ", customerStreet='" + customerStreet + '\'' +
        ", customerHouseNo='" + customerHouseNo + '\'' +
        ", customerAddress=" + customerAddress +
        ", customerTelephoneNo='" + customerTelephoneNo + '\'' +
        ", customerEmail='" + customerEmail + '\'' +
        ", customerCreationDate=" + customerCreationDate +
        '}';
  }

  /**
   * Gets identifier here customer number
   *
   * @return customer's number
   */
  public long getCustomerNo() {
    return customerNo;
  }

  /**
   * Sets customer number as primary key.
   *
   * @param customerNo customer's number to set
   */
  public void setCustomerNo(long customerNo) {
    this.customerNo = customerNo;
  }

  /**
   * Gets firstname
   *
   * @return customer's firstname
   */
  public String getCustomerFirstName() {
    return customerFirstName;
  }

  /**
   * Sets first-name
   *
   * @param customerFirstName customer's first name to set
   */
  public void setCustomerFirstName(String customerFirstName) {
    this.customerFirstName = customerFirstName;
  }

  /**
   * Gets lastname
   *
   * @return customer's lastname
   */
  public String getCustomerLastName() {
    return customerLastName;
  }

  /**
   * Sets lastname
   *
   * @param customerLastName customer's lastname to set
   */
  public void setCustomerLastName(String customerLastName) {
    this.customerLastName = customerLastName;
  }

  /**
   * Gets birthday
   *
   * @return customer's birthday
   */
  public LocalDateTime getCustomerBirthday() {
    return customerBirthday;
  }

  /**
   * Sets birthday
   *
   * @param customerBirthday customer's birthday to set
   */
  public void setCustomerBirthday(LocalDateTime customerBirthday) {
    this.customerBirthday = customerBirthday;
  }

  /**
   * Gets street
   *
   * @return customer's street
   */
  public String getCustomerStreet() {
    return customerStreet;
  }

  /**
   * Sets street
   *
   * @param customerStreet customer's street to set
   */
  public void setCustomerStreet(String customerStreet) {
    this.customerStreet = customerStreet;
  }

  /**
   * Gets house number
   *
   * @return customer's house number
   */
  public String getCustomerHouseNo() {
    return customerHouseNo;
  }

  /**
   * Sets house number
   *
   * @param customerHouseNo customer's house number
   */
  public void setCustomerHouseNo(String customerHouseNo) {
    this.customerHouseNo = customerHouseNo;
  }

  /**
   * Gets zip code
   *
   * @return customer's address
   */
  public Address getCustomerAddress() {
    return customerAddress;
  }

  /**
   * Sets zip
   *
   * @param customerAddress customer's address to set
   */
  public void setCustomerAddress(Address customerAddress) {
    this.customerAddress = customerAddress;
  }

  /**
   * Gets phone number
   *
   * @return customer's phone number
   */
  public String getCustomerTelephoneNo() {
    return customerTelephoneNo;
  }

  /**
   * Sets phone number
   *
   * @param customerTelephoneNo customer's phone number to set
   */
  public void setCustomerTelephoneNo(String customerTelephoneNo) {
    this.customerTelephoneNo = customerTelephoneNo;
  }

  /**
   * Gets e-mail
   *
   * @return customer's e-mail
   */
  public String getCustomerEmail() {
    return customerEmail;
  }

  /**
   * Sets e-mail
   *
   * @param customerEmail customer's e-mail to set
   */
  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }

  /**
   * Gets creation date
   *
   * @return customer's creation date
   */
  public LocalDateTime getCustomerCreationDate() {
    return customerCreationDate;
  }

  /**
   * Sets creation
   *
   * @param customerCreationDate customer's creation date to set
   */
  public void setCustomerCreationDate(LocalDateTime customerCreationDate) {
    this.customerCreationDate = customerCreationDate;
  }
}
