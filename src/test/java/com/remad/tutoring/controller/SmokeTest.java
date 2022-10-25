package com.remad.tutoring.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.remad.tutoring.controllers.ServiceContractController;
import com.remad.tutoring.controllers.UserController;
import com.remad.tutoring.controllers.ZipCodeController;
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