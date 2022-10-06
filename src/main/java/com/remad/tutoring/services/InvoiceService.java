package com.remad.tutoring.services;

import com.remad.tutoring.models.Invoice;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

/**
 * service to create, update and generate invoice PDFs as in memory PDF documents.
 */
public interface InvoiceService {

  /**
   * Creates invoice
   *
   * @param invoice invoice to create
   */
  void createInvoice(Invoice invoice);

  /**
   * Updates invoice
   *
   * @param id      invoice's numeric identifier for get invoice to update
   * @param invoice invoice to update / correct
   */
  void updateInvoice(long id, Invoice invoice);

  /**
   * Gets invoice.
   *
   * @param id given invoice number to retrieve
   * @return invoice
   */
  Invoice getInvoice(long id);

  /**
   * Gets all invoices
   *
   * @return all invoices from database
   */
  Collection<Invoice> getInvoices();

  /**
   * Generates PDF
   *
   * @param invoice invoice to generate invoice PDF-document for
   * @return generated PDDocument
   */
  OutputStream generatePDF(Invoice invoice) throws IOException;
}
