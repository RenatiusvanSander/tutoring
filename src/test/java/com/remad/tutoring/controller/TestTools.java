package com.remad.tutoring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

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
  public static String expectedJsoArrayToString(Object obj) throws JsonProcessingException {
    JSONArray json = new JSONArray();
    json.put(getObjectMapper().writeValueAsString(obj));

    return json.toString()
        .replace("\\", "")
        .replace("\"{", "{")
        .replace("}\"", "}");
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
   * Gets JSON Object mapper
   *
   * @return JSON Object Mapper, {@link ObjectMapper}
   */
  public static ObjectMapper getObjectMapper() {
    return OBJECT_MAPPER;
  }
}
