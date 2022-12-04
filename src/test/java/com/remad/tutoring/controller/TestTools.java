package com.remad.tutoring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.remad.tutoring.models.ServiceContract;
import java.util.Arrays;
import java.util.Collection;
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
        .writeValueAsString(responseEntity.getBody());
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
}
