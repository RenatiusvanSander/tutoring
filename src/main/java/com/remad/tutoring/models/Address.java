package com.remad.tutoring.models;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {

  /**
   * the primary key for an address
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * the street
   */
  private String addressStreet;
  /**
   * house number
   */
  private String addressHouseNo;
  /**
   * customer's zip code
   */

  @OneToOne
  @JoinColumn(name = "zipcode_id", referencedColumnName = "id")
  private ZipCode addressZipCode;

  /**
   *
   * @param addressStreet
   * @param addressHouseNo
   * @param addressZipCode
   */
  public Address(String addressStreet, String addressHouseNo, ZipCode addressZipCode) {
    this.addressStreet = addressStreet;
    this.addressHouseNo = addressHouseNo;
    this.addressZipCode = addressZipCode;
  }

  public Address() {
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getAddressStreet(), getAddressHouseNo(), addressZipCode);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Address)) {
      return false;
    }
    Address address = (Address) o;
    return getId() == address.getId() && getAddressStreet().equals(address.getAddressStreet())
        && getAddressHouseNo().equals(address.getAddressHouseNo()) && addressZipCode.equals(
        address.addressZipCode);
  }

  @Override
  public String toString() {
    return "Address{" +
        "id=" + id +
        ", addressStreet='" + addressStreet + '\'' +
        ", addressHouseNo='" + addressHouseNo + '\'' +
        ", addressZipCode=" + addressZipCode +
        '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAddressStreet() {
    return addressStreet;
  }

  public void setAddressStreet(String addressStreet) {
    this.addressStreet = addressStreet;
  }

  public String getAddressHouseNo() {
    return addressHouseNo;
  }

  public void setAddressHouseNo(String addressHouseNo) {
    this.addressHouseNo = addressHouseNo;
  }
}
