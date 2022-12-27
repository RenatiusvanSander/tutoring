package com.remad.tutoring.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import com.remad.tutoring.models.Address;
import com.remad.tutoring.models.Customer;
import com.remad.tutoring.models.ZipCode;
import com.remad.tutoring.services.CustomerService;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

/**
 * JUnit tests of {@link CustomerController}
 */
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

  /**
   * mocked address controller for tests
   */
  @Autowired
  private MockMvc mockedController;

  /**
   * mocked customer service
   */
  @MockBean
  private CustomerService mockedCustomerService;

  @Test
  public void testCreateCustomer() throws Exception {
    ZipCode zipCode = new ZipCode("Hamburg", LocalDateTime.now());
    Address address = new Address("Volksdorfer Grenzweg", "40A", zipCode);
    Customer customer = new Customer("Max", "Mustermann", LocalDateTime.now(), address, zipCode,
        "+49524472726252", "remad@hsfsfs.de", LocalDateTime.now());

    MockHttpServletResponse actualResponse = mockedController.perform(
            post("/customers/create-customer", customer).contentType(MediaType.APPLICATION_JSON)
                .content(TestTools.getObjectMapper().writeValueAsString(customer))
                .characterEncoding(StandardCharsets.UTF_8))
        .andReturn().getResponse();

    assertEquals(200, actualResponse.getStatus());
  }

  @Test
  public void testDeleteCustomer() throws Exception {
    MockHttpServletResponse actualResponse = mockedController.perform(
            delete("/customers/{id}", 1L))
        .andReturn().getResponse();

    assertEquals(200, actualResponse.getStatus());
  }

  @Test
  public void testUpdateCustomer() throws Exception {
    ZipCode zipCode = new ZipCode("Hamburg", LocalDateTime.now());
    Address address = new Address("Volksdorfer Grenzweg", "40A", zipCode);
    Customer customer = new Customer("Max", "Mustermann", LocalDateTime.now(), address, zipCode,
        "+49524472726252", "remad@hsfsfs.de", LocalDateTime.now());

    MockHttpServletResponse actualResponse = mockedController.perform(
            put("/customers/{id}", 1L, customer).contentType(MediaType.APPLICATION_JSON)
                .content(TestTools.getObjectMapper().writeValueAsString(customer))
                .characterEncoding(StandardCharsets.UTF_8))
        .andReturn().getResponse();

    assertEquals(200, actualResponse.getStatus());
  }

  @Test
  public void testGetCustomer() throws Exception {
    ZipCode zipCode = new ZipCode("Hamburg", LocalDateTime.now());
    Address address = new Address("Volksdorfer Grenzweg", "40A", zipCode);
    Customer customer = new Customer("Max", "Mustermann", LocalDateTime.now(), address, zipCode,
        "+49524472726252", "remad@hsfsfs.de", LocalDateTime.now());
    String expectedContent = TestTools.responseEntityBodyToJsonString(ResponseEntity.ok(customer));

    when(mockedCustomerService.getCustomer(1L)).thenReturn(customer);
    MockHttpServletResponse actualResponse = mockedController.perform(
            get("/customers/{id}", 1L))
        .andReturn().getResponse();

    assertEquals(200, actualResponse.getStatus());
    assertEquals(expectedContent, actualResponse.getContentAsString());
  }

  @Test
  public void testGetAllCustomers() throws Exception {
    ZipCode zipCode = new ZipCode("Hamburg", LocalDateTime.now());
    Address address = new Address("Volksdorfer Grenzweg", "40A", zipCode);
    Customer customer = new Customer("Max", "Mustermann", LocalDateTime.now(), address, zipCode,
        "+49524472726252", "remad@hsfsfs.de", LocalDateTime.now());
    String expectedContent = TestTools.responseEntityBodyToJsonString(
        ResponseEntity.ok(List.of(customer)));

    when(mockedCustomerService.getAllCustomers()).thenReturn(List.of(customer));
    MockHttpServletResponse actualResponse = mockedController.perform(
            get("/customers/get-all-customers"))
        .andReturn().getResponse();

    assertEquals(200, actualResponse.getStatus());
    assertEquals(expectedContent, actualResponse.getContentAsString());
  }
}
