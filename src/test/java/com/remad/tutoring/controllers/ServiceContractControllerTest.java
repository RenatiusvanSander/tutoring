package com.remad.tutoring.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.remad.tutoring.models.ServiceContract;
import com.remad.tutoring.services.ServiceContractService;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Unit test for {@link ServiceContractControllerTest}
 */
@WebMvcTest(ServiceContractController.class)
public class ServiceContractControllerTest {

  /**
   * mocked address controller for tests
   */
  @Autowired
  private MockMvc mockedController;

  /**
   * mocked service contract service
   */
  @MockBean
  private ServiceContractService mockedServiceContractService;

  /**
   * Sets up
   */
  @BeforeEach
  void setUp() {
  }

  /**
   * Tests
   */
  @Test
  public void testGetAllServiceContracts() throws Exception {
    ServiceContract[] expectedServiceContracts = this.createServiceContracts(LocalDateTime.now());
    String expectedJsonArray = TestTools.responseEntityBodyToJsonString(
        ResponseEntity.ok(Arrays.asList(expectedServiceContracts)));

    when(mockedServiceContractService.getAllServiceContracts()).thenReturn(
        Arrays.asList(expectedServiceContracts));
    MockHttpServletResponse actualResponse = mockedController
        .perform(get("/service-contracts/get-all"))
        .andExpect(status().isOk())
        .andReturn().getResponse();

    assertEquals(MediaType.APPLICATION_JSON_VALUE, actualResponse.getContentType());
    assertEquals(expectedJsonArray, actualResponse.getContentAsString());
  }

  /**
   * Creates service contracts
   *
   * @param localDateTime the local date time to set
   * @return created three service contracts
   */
  private ServiceContract[] createServiceContracts(LocalDateTime localDateTime) {
    ServiceContract sc1 = new ServiceContract("Nachhilfe Elektrotechnik",
        "ET Nachhilfe der Grundlagen 1 bis 2", localDateTime);
    ServiceContract sc2 = new ServiceContract("Nachhilfe Informatik",
        "Informatik Nachhilfe in mehrere Programmiersprachen", localDateTime);
    ServiceContract sc3 = new ServiceContract("Nachhilfe Mathmatik", "Mathematik alle Klassen",
        localDateTime);

    return new ServiceContract[]{sc1, sc2, sc3};
  }

  @Test
  public void testGetServiceContract() throws Exception {
    ServiceContract sc1 = new ServiceContract("Nachhilfe Elektrotechnik",
        "ET Nachhilfe der Grundlagen 1 bis 2", LocalDateTime.now());
    String expectedContent = TestTools.responseEntityBodyToJsonString(ResponseEntity.ok(sc1));
    long pathVariable = 12L;
    when(mockedServiceContractService.getServiceContract(pathVariable)).thenReturn(sc1);

    MockHttpServletResponse actualResponse = mockedController
        .perform(get("/service-contracts/{id}", pathVariable))
        .andExpect(status().isOk())
        .andReturn().getResponse();

    assertEquals(expectedContent, actualResponse.getContentAsString());
  }

  @Test
  public void testCreateServiceContract() throws Exception {
    ServiceContract sc1 = new ServiceContract("Nachhilfe Elektrotechnik",
        "ET Nachhilfe der Grundlagen 1 bis 2", LocalDateTime.now());
    String json = TestTools.getObjectMapper().writeValueAsString(sc1);

    MockHttpServletResponse actualResponse = mockedController
        .perform(post("/service-contracts/create-service-contract")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json)
            .characterEncoding(StandardCharsets.UTF_8))
        .andReturn()
        .getResponse();

    assertEquals(200, actualResponse.getStatus());
  }

  @Test
  public void testDeleteServiceContract() throws Exception {
    MockHttpServletResponse actualResponse = mockedController
        .perform(delete("/service-contracts/{id}", 1L))
        .andReturn().getResponse();

    assertEquals(200, actualResponse.getStatus());
  }

  @Test
  public void testUpdateServiceContract() throws Exception {
    ServiceContract sc1 = new ServiceContract("Nachhilfe Elektrotechnik",
        "ET Nachhilfe der Grundlagen 1 bis 2", LocalDateTime.now());

    MockHttpServletResponse actualResponse = mockedController
        .perform(put("/service-contracts/{id}", 2L, sc1)
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestTools.getObjectMapper().writeValueAsString(sc1))
            .characterEncoding(StandardCharsets.UTF_8))
        .andReturn()
        .getResponse();

    assertEquals(200, actualResponse.getStatus());
  }
}