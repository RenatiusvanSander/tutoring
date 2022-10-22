package com.remad.tutoring.services;

import com.remad.tutoring.models.ZipCode;

/**
 * Postal zip code service concern about create, delete and exists of zip codes.
 */
public interface ZipCodeService {

  /**
   * Creates zip code.
   *
   * @param zipCode given zip code to create for
   */
  void create(ZipCode zipCode);

  /**
   * Deletes zip code
   *
   * @param id zip code's numeric identifier to delete
   */
  void delete(long id);

  /**
   * Validates zip code exists.
   *
   * @param zipCode numeric zip code to check for exists
   * @return true / false for zip code exists
   */
  boolean exists(long zipCode);

  /**
   * Gets ZioCode
   *
   * @param id zipcode's identifier
   * @return the zip code
   */
  ZipCode getZipCode(long id);
}
