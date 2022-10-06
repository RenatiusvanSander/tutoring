package com.remad.tutoring.services;

import com.remad.tutoring.models.Invoice;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;

/**
 * Implementation for {@link PDFCreationService}. Service creates PDF-document from an
 * {@link Invoice} instance.
 */
public class PDFCreationServiceImpl implements PDFCreationService {

  /**
   * PDFCreationServiceImpl Constructor
   */
  public PDFCreationServiceImpl() {
  }

  @Override
  public OutputStream createPDF(Invoice invoice, InvoiceService invoiceService)
      throws IOException {
    PDDocument pdfDocument = new PDDocument();
    PDStream pdStream = new PDStream(pdfDocument);

    return pdStream.createOutputStream();
  }
}
