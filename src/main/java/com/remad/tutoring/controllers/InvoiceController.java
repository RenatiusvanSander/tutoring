package com.remad.tutoring.controllers;

import com.remad.tutoring.models.Invoice;
import com.remad.tutoring.services.InvoiceService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * REST Controller for invoices concnerning create, read, update and delete
 */
@Controller
@RequestMapping("/invoices")
public class InvoiceController {

  /**
   * the invoice service to actions concerning invoice
   */
  @Autowired
  private final InvoiceService invoiceService;

  /**
   * InvoiceController Constructor
   *
   * @param invoiceService the invoice service to perform actions
   */
  public InvoiceController(InvoiceService invoiceService) {
    this.invoiceService = invoiceService;
  }

  /**
   * Creates invoice
   *
   * @param invoice the invoice to create
   * @return response with status
   */
  @PostMapping("/create-invoice")
  @ResponseBody
  public ResponseEntity<Object> createInvoice(@RequestBody Invoice invoice) {
    try {
      this.invoiceService.createInvoice(invoice);

      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (Exception ex) {
      return ResponseEntity.internalServerError().build();
    }
  }

  /**
   * Gets invoice
   *
   * @param id numeric invoice identifer to get matching invoice
   * @return the matching invoice and http status 200 for ok. In case of not found the status 404.
   */
  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Invoice> getInvoice(@PathVariable long id) {
    Invoice invoiceToReturn = this.invoiceService.getInvoice(id);

    return ResponseEntity.ok(invoiceToReturn);
  }

  /**
   * Deletes invoice
   *
   * @param id numeric identifer of invoice
   * @return http status 200. In case of invoice not found http status 404 or internal server error.
   */
  @DeleteMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Object> deleteInvoice(@PathVariable long id) {
    try {
      return ResponseEntity.ok().build();
    } catch (Exception ex) {
      return ResponseEntity.notFound().build();
    }
  }

  /**
   * Updates invoice.
   *
   * @param id             numeric identifier of the invoice to update
   * @param updatedInvoice the update invoice to to save
   * @return In case of update is done the status 200 returned. In case of update is not done status
   * 404 for not found.
   */
  @PutMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Object> updateInvoice(@PathVariable long id,
      @RequestBody Invoice updatedInvoice) {
    try {
      this.invoiceService.updateInvoice(id, updatedInvoice);

      return ResponseEntity.ok().build();
    } catch (Exception ex) {
      return ResponseEntity.notFound().build();
    }
  }

  /**
   * Gets all invoices
   *
   * @return all invoices with status 200. Otherwise internal server error.
   */
  @GetMapping("/get-all-invoices")
  @ResponseBody
  public ResponseEntity<Collection<Invoice>> getAllInvoices() {
    try {
      Collection<Invoice> allInvoices = this.invoiceService.getInvoices();

      return ResponseEntity.ok(allInvoices);
    } catch (Exception ex) {
      return ResponseEntity.internalServerError().build();
    }
  }

  /**
   * Generates invoice PDF.
   *
   * @param id the numeric invoice identifier
   * @return a byte-stream that is a PDF
   * @throws IOException
   */
  @GetMapping("/generate-invoice-pdf/{id}")
  public OutputStream generatePDF(@PathVariable long id) throws IOException {
    Invoice invoiceToPdf = this.invoiceService.getInvoice(id);

    if (invoiceToPdf == null) {
      try (OutputStream outputStream = new FileOutputStream("")) {
        outputStream.write(ResponseEntity.notFound().build().toString().getBytes());

        return outputStream;
      } catch (Exception ex) {
        try (OutputStream outputStream = new FileOutputStream("")) {
          outputStream.write(ResponseEntity.internalServerError().build().toString().getBytes());

          return outputStream;
        }
      }
    }

    return this.invoiceService.generatePDF(invoiceToPdf);
  }
}
