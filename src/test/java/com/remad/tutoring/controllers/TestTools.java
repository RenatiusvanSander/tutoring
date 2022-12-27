package com.remad.tutoring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.remad.tutoring.models.Address;
import com.remad.tutoring.models.Customer;
import com.remad.tutoring.models.TutoringAppointment;
import com.remad.tutoring.models.ZipCode;
import java.time.LocalDateTime;
import org.json.JSONArray;
import org.springframework.http.ResponseEntity;

/**
 * Test tools concerning spring boot tests
 */
public class TestTools {

  /**
   * the object mapper
   */
  private static final ObjectMapper OBJECT_MAPPER = createObjectMapper();

  /**
   * private constructor
   */
  private TestTools() {
    throw new IllegalAccessError("Pease access in a static way.");
  }

  /**
   * Converts {@link JSONArray} to {qlink String}
   *
   * @param obj the object to convert to string-encoded JsonArray
   * @return string-encoded json-array
   */
  public static String expectedJsoArrayToString(Object... obj) throws JsonProcessingException {
    JSONArray json = new JSONArray();
    json.put(getObjectMapper().writeValueAsString(obj));

    return json.toString()
        .replace("\\", "")
        .replace("\"{", "{")
        .replace("}\"", "}")
        .replace("\"}]\"", "\"}")
        .replace("\"[{", "{");
  }

  /**
   * Gets JSON Object mapper
   *
   * @return JSON Object Mapper, {@link ObjectMapper}
   */
  public static ObjectMapper getObjectMapper() {
    return OBJECT_MAPPER;
  }

  /**
   * Converts {@link ResponseEntity} to string-encoded JSON
   *
   * @param responseEntity the given response entity to convert
   * @return string-encoded JSON
   * @throws JsonProcessingException
   */
  public static String responseEntityBodyToJsonString(ResponseEntity<?> responseEntity)
      throws JsonProcessingException {
    return getObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .writeValueAsString(responseEntity.getBody()).replace("ä", "Ã¤");
  }

  /**
   * Creates object mapper
   *
   * @return object mapper
   */
  public static ObjectMapper createObjectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.findAndRegisterModules();

    return mapper;
  }

  /**
   * Creates createTutoringAppointment
   *
   * @return created Tutoring Appointment
   */
  public static TutoringAppointment createTutoringAppointment() {
    Customer customer = createCustomer();

    return new
        TutoringAppointment(customer, customer.getCustomerCreationDate(),
        customer.getCustomerCreationDate(), customer.getCustomerCreationDate());
  }

  /**
   * Creates Customer
   *
   * @return created customer
   */
  public static Customer createCustomer() {
    return new Customer("Max", "Mustermann", LocalDateTime.now(), createAddress(), createZipCode(),
        "+49524472726252", "remad@hsfsfs.de", LocalDateTime.now());
  }

  /**
   * Creates address
   *
   * @return created address
   */
  public static Address createAddress() {
    return new Address("Volksdorfer Grenzweg", "40A", createZipCode());
  }

  /**
   * creates zip code
   *
   * @return created zip code
   */
  public static ZipCode createZipCode() {
    return new ZipCode("Hamburg", LocalDateTime.now());
  }
}
