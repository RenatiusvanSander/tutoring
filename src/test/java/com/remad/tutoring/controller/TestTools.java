package com.remad.tutoring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test tools concerning spring boot tests
 */
public class TestTools {

  /**
   * private constructor
   */
  private TestTools() {
    throw new IllegalAccessError("Okease access in a static way.");
  }

  /**
   * the object mapper
   */
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  /**
   * Gets object mapper
   *
   * @return object mapper
   */
  public static ObjectMapper getObjectMapper() {
    ObjectMapper mapper = OBJECT_MAPPER;
    mapper.findAndRegisterModules();

    return mapper;
  }
}
