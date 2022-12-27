package com.remad.tutoring.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.remad.tutoring.models.TutoringAppointment;
import com.remad.tutoring.services.TutoringAppointmentService;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
}
