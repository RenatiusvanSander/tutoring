package com.remad.tutoring.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import com.remad.tutoring.models.TutoringAppointment;
import com.remad.tutoring.services.TutoringAppointmentService;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

/**
 * JUnit test for {@link TutoringAppointmentController}
 */
@WebMvcTest(TutoringAppointmentController.class)
public class TutoringAppointmentControllerTest {

  /**
   * mocked tutoring appointment controller for tests
   */
  @Autowired
  private MockMvc mockedController;

  /**
   * Mocked tutoring appointment service
   */
  @MockBean
  private TutoringAppointmentService mockedTutoringAppointmentService;

  @Test
  public void testCreateTutoringAppointment() throws Exception {
    TutoringAppointment appointment = TestTools.createTutoringAppointment();

    MockHttpServletResponse actualResponse = mockedController.perform(
            post("/tutoring-appointments", appointment)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestTools.getObjectMapper().writeValueAsString(appointment))
                .characterEncoding(StandardCharsets.UTF_8))
        .andReturn().getResponse();

    assertEquals(201, actualResponse.getStatus());
  }

  @Test
  public void testGetTutoringAppointment() throws Exception {
    TutoringAppointment appointment = TestTools.createTutoringAppointment();
    ResponseEntity<TutoringAppointment> responseEntity = ResponseEntity.ok(appointment);
    String expectedContent = TestTools.responseEntityBodyToJsonString(responseEntity);

    MockHttpServletResponse actualResponse = mockedController.perform(
            get("/tutoring-appointments/{id}", 89L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestTools.getObjectMapper().writeValueAsString(appointment))
                .characterEncoding(StandardCharsets.UTF_8))
        .andReturn().getResponse();

    assertEquals(200, actualResponse.getStatus());
    assertEquals(expectedContent, actualResponse.getContentAsString());
  }

  @Test
  public void testUpdateTutoringAppointment() throws Exception {
    TutoringAppointment appointment = TestTools.createTutoringAppointment();

    MockHttpServletResponse actualResponse = mockedController.perform(
            put("/tutoring-appointments/{id}", 89L, appointment)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestTools.getObjectMapper().writeValueAsString(appointment))
                .characterEncoding(StandardCharsets.UTF_8))
        .andReturn().getResponse();

    assertEquals(200, actualResponse.getStatus());
  }

  @Test
  public void testDeleteTutoringAppointment() throws Exception {
    MockHttpServletResponse actualResponse = mockedController.perform(
            delete("/tutoring-appointments/{id}", 64L))
        .andReturn().getResponse();

    assertEquals(200, actualResponse.getStatus());
  }
}
