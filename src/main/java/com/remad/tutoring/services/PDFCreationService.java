package com.remad.tutoring.services;

import com.remad.tutoring.models.Invoice;
import java.io.IOException;
import java.io.OutputStream;

/**
 * service for creation of PDF-documents
 */
public interface PDFCreationService {

  /**
   * Creates PDF
   *
   * @param invoice        invoice to generate PDF for
   * @param invoiceService invoice service for access invoice data
   * @return PDF document
   * @throws IOException in case the pdf document fails in generation, the
   *                     {@link java.io.OutputStream} has no source from in-memory PDF-file.
   */
  OutputStream createPDF(Invoice invoice, InvoiceService invoiceService) throws IOException;
}
