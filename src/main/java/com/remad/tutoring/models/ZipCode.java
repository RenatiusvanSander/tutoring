package com.remad.tutoring.models;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity is concerning the zip code of a location.
 */
@Entity
public class ZipCode {

  /**
   * Constructor
   */
  public ZipCode() {
  }

  /**
   * Constructor
   *
   * @param zipCode             the zip code as primary key
   * @param zipCodeLocation     location of belonging zip code
   * @param zipCodeCreationDate creation time of the zip code
   */
  public ZipCode(long zipCode, String zipCodeLocation, LocalDateTime zipCodeCreationDate) {
    this.zipCode = zipCode;
    this.zipCodeLocation = zipCodeLocation;
    this.zipCodeCreationDate = zipCodeCreationDate;
  }

  /**
   * primary key for the zip code
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long zipCode;

  /**
   * location of zip code
   */
  private String zipCodeLocation;

  /**
   * creation date of zip code
   */
  private LocalDateTime zipCodeCreationDate;
}
