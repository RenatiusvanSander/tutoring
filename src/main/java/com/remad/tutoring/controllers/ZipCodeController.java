package com.remad.tutoring.controllers;

import com.remad.tutoring.models.ZipCode;
import com.remad.tutoring.services.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

/**
 * Controller concerning deleting, creating, validating and getting all zip codes.
 */
@Controller
@RequestMapping("/zipcodes")
public class ZipCodeController {

  @Autowired
  private ZipCodeService zipCodeService;

  /**
   * Gets zip code by id.
   *
   * @param id zipcode's identifier
   * @return matching zipcode
   */
  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity<ZipCode> getZipCode(@PathVariable long id) {
    try {
      ZipCode zipCode = this.zipCodeService.getZipCode(id);

      return ResponseEntity.ok(zipCode);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot get ZipCode.",
          e);
    }
  }

  /**
   * Creates ZipCode
   *
   * @param zipCode given zipcode to create
   * @return In case of success HTTP status 200. In case of failed internal server error iy
   * returned.
   */
  @PostMapping("/create-zipcode")
  @ResponseBody
  public ResponseEntity<Object> createZipCode(@RequestBody ZipCode zipCode) {
    try {
      this.zipCodeService.create(zipCode);

      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot get ZipCode.",
          e);
    }
  }

  /**
   * Validate a zip code exists
   *
   * @param id zip code's identifier to validate that exists
   * @return True for the zip code exists. Otherwise false.
   */
  @GetMapping("/exists/{id}")
  public ResponseEntity<Object> exists(@PathVariable long id) {
    boolean isZipCodeExistent = this.zipCodeService.exists(id);

    return isZipCodeExistent ?
        ResponseEntity.ok(true) :
        ResponseEntity.notFound().build();
  }

  /**
   * Deletes Zip Code.
   *
   * @param id zip code identifier to delete zipcode
   * @return Returns http status 200 for deleted. Otherwise htp status 500 internal server error is
   * returned.
   */
  @DeleteMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Object> deleteZipCode(@PathVariable long id) {
    try {
      this.zipCodeService.delete(id);

      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot delete ZipCode.",
          e);
    }
  }
}
