package com.remad.tutoring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.remad.tutoring.controllers.AddressController;
import com.remad.tutoring.models.Address;
import com.remad.tutoring.models.ZipCode;
import com.remad.tutoring.services.AddressService;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Junit tests for {@link AddressController}
 */
@WebMvcTest(AddressController.class)
public class AddressControllerTest {

  /**
   * mocked address controller for tests
   */
  @Autowired
  private MockMvc mockedController;

  /**
   * mocked address service for tests
   */
  @MockBean
  private AddressService addressService;

  @Test
  public void testGetsAddressesShouldReturnAddresses() throws Exception {
    Address address = this.createAddress();
    String expectedJsonArray = TestTools.expectedJsoArrayToString(address);

    when(addressService.getsAddresses()).thenReturn(List.of(address));

    String actualJson = mockedController.perform(get("/addresses/all"))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();
    assertEquals(expectedJsonArray, actualJson);
  }

  /**
   * Creates address
   *
   * @return created address
   */
  private Address createAddress() {
    ZipCode zipCode = new ZipCode("Hamburg", LocalDateTime.now());

    return new Address("Volksdorfer Grenzweg", "40A", zipCode);
  }

  @Test
  public void testGetAddressShouldReturnExpectedAddress() throws Exception {
    Address address = this.createAddress();
    String expectedJson = TestTools.getObjectMapper().writeValueAsString(address);

    long pathVariableId = 742L;
    when(addressService.getAddress(pathVariableId)).thenReturn(address);

    String actualJson = mockedController.perform(get("/addresses/{id}", pathVariableId))
        .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    assertEquals(expectedJson, actualJson);
  }

  @Test
  public void testDeleteAddressShouldReturnStatusOk() throws Exception {
    long pathVariableId = 742L;
    mockedController.perform(delete("/addresses/{id}", pathVariableId)).andExpect(status().isOk());
  }
}
