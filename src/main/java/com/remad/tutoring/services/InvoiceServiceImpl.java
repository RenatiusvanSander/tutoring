package com.remad.tutoring.services;

import com.remad.tutoring.dao.InvoiceRepository;
import com.remad.tutoring.models.Invoice;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 * Implementation of invoice service to create, update, creating PDF, gets single invoice and get
 * all invoices.
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

  /**
   * service contract service
   */
  private final ServiceContractService serviceContractService;

  /**
   * customer service
   */
  private final CustomerService customerService;

  /**
   * invoice repository for persistence and database operations
   */
  private final InvoiceRepository invoiceRepository;

  /**
   * service for creation of PDFs
   */
  private final PDFCreationService pdfCreationService;

  /**
   * Constructor
   *
   * @param serviceContractService service contract service for persistence and database operations
   * @param customerService        customer service for persistence and database operations
   * @param invoiceRepository      invoice repository for persistence and database operations.
   * @param pdfService             PDF service for creating PDF-documents for invoices
   */
  public InvoiceServiceImpl(final ServiceContractService serviceContractService,
      final CustomerService customerService, final InvoiceRepository invoiceRepository,
      final PDFCreationService pdfService) {
    this.serviceContractService = serviceContractService;
    this.customerService = customerService;
    this.invoiceRepository = invoiceRepository;
    this.pdfCreationService = pdfService;
  }

  @Override
  public void createInvoice(Invoice invoice) {
    this.invoiceRepository.saveAndFlush(invoice);
  }

  @Override
  public void updateInvoice(long id, Invoice invoice) {
    Invoice invoiceToUpdate = this.invoiceRepository.getReferenceById(id);

    if (invoice.getInvoiceNo() != id) {
      invoiceToUpdate.setInvoiceServiceContract(invoice.getInvoiceServiceContract());
      invoiceToUpdate.setInvoiceTutoringHours(invoice.getInvoiceTutoringHours());
      invoiceToUpdate.setInvoiceDate(invoice.getInvoiceDate());
      invoiceToUpdate.setInvoiceTutoringDate(invoice.getInvoiceTutoringDate());
      invoiceToUpdate.setInvoiceCustomer(invoice.getInvoiceCustomer());

      this.invoiceRepository.saveAndFlush(invoiceToUpdate);
    }
  }

  @Override
  public Invoice getInvoice(long id) {
    return this.invoiceRepository.getReferenceById(id);
  }

  @Override
  public Collection<Invoice> getInvoices() {
    return this.invoiceRepository.findAll();
  }

  @Override
  public OutputStream generatePDF(Invoice invoice) throws IOException {
    return pdfCreationService.createPDF(invoice, this);
  }
}
