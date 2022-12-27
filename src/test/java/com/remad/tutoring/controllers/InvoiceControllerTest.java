package com.remad.tutoring.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import com.remad.tutoring.models.Address;
import com.remad.tutoring.models.Customer;
import com.remad.tutoring.models.Invoice;
import com.remad.tutoring.models.ServiceContract;
import com.remad.tutoring.models.ZipCode;
import com.remad.tutoring.services.InvoiceService;
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
 * JUnit tests for {@link InvoiceController}
 */
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {

  /**
   * mocked address controller for tests
   */
  @Autowired
  private MockMvc mockedController;

  /**
   * mocked invoice service
   */
  @MockBean
  private InvoiceService mockedInvoiceService;

  @Test
  public void testCreateInvoice() throws Exception {
    ServiceContract serviceContract = new ServiceContract("Nachhilfe Mathematik",
        "Mathematik in sämtlichen Klassen", LocalDateTime.now());
    ZipCode zipCode = new ZipCode("Hamburg", LocalDateTime.now());
    Address address = new Address("Volksdorfer Grenzweg", "40A", zipCode);
    Customer customer = new Customer("Remy", "Meierle", LocalDateTime.now(), address, zipCode,
        "+4915352772277272", "info@remad.de", LocalDateTime.now());
    Invoice invoice = new Invoice(serviceContract, 2.0F, LocalDateTime.now(), LocalDateTime.now(),
        customer, LocalDateTime.now());

    MockHttpServletResponse actualResponse = mockedController.perform(
            post("/invoices/create-invoice", invoice)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestTools.getObjectMapper().writeValueAsString(invoice))
                .characterEncoding(StandardCharsets.UTF_8))
        .andReturn().getResponse();
    assertEquals(201, actualResponse.getStatus());
  }

  @Test
  public void testGetInvoice() throws Exception {
    ServiceContract serviceContract = new ServiceContract("Nachhilfe Mathematik",
        "Mathematik in sämtlichen Klassen", LocalDateTime.now());
    ZipCode zipCode = new ZipCode("Hamburg", LocalDateTime.now());
    Address address = new Address("Volksdorfer Grenzweg", "40A", zipCode);
    Customer customer = new Customer("Remy", "Meierle", LocalDateTime.now(), address, zipCode,
        "+4915352772277272", "info@remad.de", LocalDateTime.now());
    Invoice invoice = new Invoice(serviceContract, 2.0F, LocalDateTime.now(), LocalDateTime.now(),
        customer, LocalDateTime.now());
    String expectedContent = TestTools.responseEntityBodyToJsonString(ResponseEntity.ok(invoice));

    when(this.mockedInvoiceService.getInvoice(4L)).thenReturn(invoice);

    MockHttpServletResponse actualResponse = mockedController.perform(
            get("/invoices/{id}", 4L))
        .andReturn().getResponse();

    assertEquals(200, actualResponse.getStatus());
    assertEquals(expectedContent, actualResponse.getContentAsString());
  }

  @Test
  public void testDeleteInvoice() throws Exception {
    MockHttpServletResponse actualResponse = mockedController.perform(
            delete("/invoices/{id}", 15L))
        .andReturn().getResponse();

    assertEquals(200, actualResponse.getStatus());
  }

  @Test
  public void testUpdateInvoice() throws Exception {
    ServiceContract serviceContract = new ServiceContract("Nachhilfe Mathematik",
        "Mathematik in sämtlichen Klassen", LocalDateTime.now());
    ZipCode zipCode = new ZipCode("Hamburg", LocalDateTime.now());
    Address address = new Address("Volksdorfer Grenzweg", "40A", zipCode);
    Customer customer = new Customer("Remy", "Meierle", LocalDateTime.now(), address, zipCode,
        "+4915352772277272", "info@remad.de", LocalDateTime.now());
    Invoice invoice = new Invoice(serviceContract, 2.0F, LocalDateTime.now(), LocalDateTime.now(),
        customer, LocalDateTime.now());

    MockHttpServletResponse actualResponse = mockedController
        .perform(
            put("/invoices/{id}", 15L, invoice)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestTools.getObjectMapper().writeValueAsString(invoice))
                .characterEncoding(StandardCharsets.UTF_8)
        )
        .andReturn().getResponse();

    assertEquals(200, actualResponse.getStatus());
  }

  @Test
  public void testGetAllInvoices() throws Exception {
    ServiceContract serviceContract = new ServiceContract("Nachhilfe Mathematik",
        "Mathematik in sämtlichen Klassen", LocalDateTime.now());
    ZipCode zipCode = new ZipCode("Hamburg", LocalDateTime.now());
    Address address = new Address("Volksdorfer Grenzweg", "40A", zipCode);
    Customer customer = new Customer("Remy", "Meierle", LocalDateTime.now(), address, zipCode,
        "+4915352772277272", "info@remad.de", LocalDateTime.now());
    Invoice invoice = new Invoice(serviceContract, 2.0F, LocalDateTime.now(), LocalDateTime.now(),
        customer, LocalDateTime.now());
    String expectedContent = TestTools.responseEntityBodyToJsonString(ResponseEntity.ok(invoice));

    when(mockedInvoiceService.getInvoices()).thenReturn(List.of(invoice));
    MockHttpServletResponse actualResponse = mockedController
        .perform(
            get("/invoices/get-all-invoices")
        )
        .andReturn().getResponse();

    assertEquals(200, actualResponse.getStatus());
    assertEquals(expectedContent, actualResponse.getContentAsString());
  }

  @Test
  public void testGeneratePDF() {
    // empty for now
  }
}
