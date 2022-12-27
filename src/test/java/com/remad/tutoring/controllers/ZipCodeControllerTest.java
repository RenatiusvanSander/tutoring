package com.remad.tutoring.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.remad.tutoring.models.ZipCode;
import com.remad.tutoring.services.ZipCodeService;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Junit tests for {@link ZipCodeController}
 */
@WebMvcTest(ZipCodeController.class)
public class ZipCodeControllerTest {

  /**
   * the mocked bean of {@link ZipCodeService}
   */
  @MockBean
  private ZipCodeService zipCodeService;

  /**
   * mocked zip code controller for tests
   */
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void existsShouldReturnHttpStatus() throws Exception {
    long pathVariableId = 1L;
    when(zipCodeService.exists(pathVariableId)).thenReturn(true);

    mockMvc.perform(get("/zipcodes/exists/{id}", pathVariableId))
        .andExpect(status().isOk());
  }

  @Test
  public void testDeleteZipCodeShouldReturnHttpStatusOk() throws Exception {
    long pathVariableId = 5L;

    mockMvc.perform(delete("/zipcodes/{id}", pathVariableId))
        .andExpect(status().isOk());
  }

  @Test
  public void testCreateZipCodeShouldReturnHttpStatusOk() throws Exception {
    ZipCode zipCodeToCreate = new ZipCode("Hamburg", LocalDateTime.now());
    String json = TestTools.getObjectMapper().writeValueAsString(zipCodeToCreate);

    mockMvc.perform(
            post("/zipcodes/create-zipcode")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .characterEncoding("utf-8"))
        .andExpect(status().isOk());
  }

  @Test
  public void testGetZipCodeShouldReturnExpectedZipCode() throws Exception {
    long pathVariableId = 225L;
    String expectedZipCodeLocation = "Hamburg";
    LocalDateTime expectedDateTime = LocalDateTime.now();
    when(zipCodeService.getZipCode(pathVariableId)).thenReturn(
        new ZipCode(expectedZipCodeLocation, expectedDateTime));

    mockMvc.perform(get("/zipcodes/{id}", pathVariableId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.zipCodeLocation").value(expectedZipCodeLocation))
        .andExpect(jsonPath("$.zipCodeCreationDate").value(expectedDateTime.toString()));
  }
}
