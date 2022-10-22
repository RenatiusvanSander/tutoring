package com.remad.tutoring.controllers;

import com.remad.tutoring.models.ZipCode;
import com.remad.tutoring.services.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

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
}
