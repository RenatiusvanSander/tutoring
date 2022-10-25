package com.remad.tutoring.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.remad.tutoring.controllers.ZipCodeController;
import com.remad.tutoring.services.ZipCodeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ZipCodeController.class)
public class ZipCodeControllerTest {

  @MockBean
  private ZipCodeService zipCodeService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void existsShouldReturnHttpStatus() throws Exception {
    long pathVariableId = 1L;
    when(zipCodeService.exists(pathVariableId)).thenReturn(true);

    mockMvc.perform(get("/zipcodes/exists/{id}", pathVariableId))
        .andExpect(status().isOk());
  }
}
