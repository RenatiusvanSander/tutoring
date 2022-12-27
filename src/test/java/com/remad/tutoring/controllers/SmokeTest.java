package com.remad.tutoring.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Smoke test for the controllers.
 */
@SpringBootTest
public class SmokeTest {

  /**
   * service contract controller
   */
  @Autowired
  private ServiceContractController serviceContractController;

  /**
   * user controller
   */
  @Autowired
  private UserController userController;

  /**
   * zip code controller
   */
  @Autowired
  private ZipCodeController zipCodeController;

  @Test
  public void contextLoads() throws Exception {
    assertThat(serviceContractController).isNotNull();
    assertThat(userController).isNotNull();
    assertThat(zipCodeController).isNotNull();
  }
}