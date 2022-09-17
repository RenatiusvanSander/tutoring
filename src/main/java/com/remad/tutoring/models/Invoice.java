package com.remad.tutoring.models;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * customer's invoice for a done tutoring appointment.
 */
@Entity
@Table(name = "Invoice")
public class Invoice {

  /**
   * invoice number of done tutoring and primary key for invoices
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "invoice_no")
  private long invoiceNo;

  /**
   * service contract of invoice
   */
  //TODO mapping to primary key of 'service contract no'
  private long invoiceServiceContractNo;

  /**
   * amount of done tutoring hours to pay for
   */
  private float invoiceTutoringHours;

  /**
   * date of invoice
   */
  @Column(name = "invoice_date", columnDefinition = "TIMESTAMP")
  private LocalDateTime invoiceDate;

  /**
   * tutoring date of the invoice
   */
  @Column(name = "invoice_tutoring_date", columnDefinition = "TIMESTAMP")
  private LocalDateTime invoiceTutoringDate;

  /**
   * customer's no of invoice
   */
  //TODO mapping to primary key of 'customer no'
  private long invoiceCustomerNo;

  /**
   * creation date of invoice
   */
  @Column(name = "invoice_creation_date", columnDefinition = "TIMESTAMP")
  private LocalDateTime invoiceCreationDate;

  /**
   * Constructor
   */
  public Invoice() {
  }

  /**
   * Constructor
   *
   * @param invoiceServiceContractNo given invoice's service contract
   * @param invoiceTutoringHours     given invoice's tutoring hours
   * @param invoiceDate              given invoice's date
   * @param invoiceTutoringDate      given invoice's tutoring date
   * @param invoiceCustomerNo        given invoice's customer no
   * @param invoiceCreationDate      given invoice's creation date of this data set
   */
  public Invoice(long invoiceServiceContractNo,
      float invoiceTutoringHours,
      LocalDateTime invoiceDate,
      LocalDateTime invoiceTutoringDate,
      long invoiceCustomerNo,
      LocalDateTime invoiceCreationDate) {
    this.invoiceServiceContractNo = invoiceServiceContractNo;
    this.invoiceTutoringHours = invoiceTutoringHours;
    this.invoiceDate = invoiceDate;
    this.invoiceTutoringDate = invoiceTutoringDate;
    this.invoiceCustomerNo = invoiceCustomerNo;
    this.invoiceCreationDate = invoiceCreationDate;
  }

  /**
   * Gets number
   *
   * @return invoice's number
   */
  public long getInvoiceNo() {
    return invoiceNo;
  }

  /**
   * Sets number
   *
   * @param invoiceNo invoice's number to set
   */
  public void setInvoiceNo(long invoiceNo) {
    this.invoiceNo = invoiceNo;
  }

  /**
   * Gets service contract
   *
   * @return invoice's service contract
   */
  public long getInvoiceServiceContractNo() {
    return invoiceServiceContractNo;
  }

  /**
   * Sets service contract
   *
   * @param invoiceServiceContractNo invoice's service contract to set
   */
  public void setInvoiceServiceContractNo(long invoiceServiceContractNo) {
    this.invoiceServiceContractNo = invoiceServiceContractNo;
  }

  /**
   * Gets tutoring hours
   *
   * @return invoice's tutoring hours
   */
  public float getInvoiceTutoringHours() {
    return invoiceTutoringHours;
  }

  /**
   * Sets tutoring hours
   *
   * @param invoiceTutoringHours invoice's tutoring hours to set
   */
  public void setInvoiceTutoringHours(float invoiceTutoringHours) {
    this.invoiceTutoringHours = invoiceTutoringHours;
  }

  /**
   * Gets date of invoice
   *
   * @return invoice's date
   */
  public LocalDateTime getInvoiceDate() {
    return invoiceDate;
  }

  /**
   * Sets date of invoice
   *
   * @param invoiceDate invoice's date to set
   */
  public void setInvoiceDate(LocalDateTime invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  /**
   * Gets tutoring date
   *
   * @return invoice's tutoring date
   */
  public LocalDateTime getInvoiceTutoringDate() {
    return invoiceTutoringDate;
  }

  /**
   * Sets tutoring date
   *
   * @param invoiceTutoringDate invoice's tutoring date to set
   */
  public void setInvoiceTutoringDate(LocalDateTime invoiceTutoringDate) {
    this.invoiceTutoringDate = invoiceTutoringDate;
  }

  /**
   * Gets customer number.
   *
   * @return invoice's customer number
   */
  public long getInvoiceCustomerNo() {
    return invoiceCustomerNo;
  }

  /**
   * Sets customer number.
   *
   * @param invoiceCustomerNo invoice's customer number to set
   */
  public void setInvoiceCustomerNo(long invoiceCustomerNo) {
    this.invoiceCustomerNo = invoiceCustomerNo;
  }

  /**
   * Gets creation date
   *
   * @return invoice's creation date
   */
  public LocalDateTime getInvoiceCreationDate() {
    return invoiceCreationDate;
  }

  /**
   * Sets creation date
   *
   * @param invoiceCreationDate invoice's creation date to set
   */
  public void setInvoiceCreationDate(LocalDateTime invoiceCreationDate) {
    this.invoiceCreationDate = invoiceCreationDate;
  }

  @Override
  public int hashCode() {
    return Objects.hash(invoiceNo, invoiceServiceContractNo, invoiceTutoringHours, invoiceDate,
        invoiceTutoringDate, invoiceCustomerNo, invoiceCreationDate);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Invoice)) {
      return false;
    }

    Invoice invoice = (Invoice) o;
    return invoiceNo == invoice.invoiceNo
        && invoiceServiceContractNo == invoice.invoiceServiceContractNo
        && Float.compare(invoice.invoiceTutoringHours, invoiceTutoringHours) == 0
        && invoiceCustomerNo == invoice.invoiceCustomerNo && invoiceDate.equals(invoice.invoiceDate)
        && invoiceTutoringDate.equals(invoice.invoiceTutoringDate) && invoiceCreationDate.equals(
        invoice.invoiceCreationDate);
  }

  @Override
  public String toString() {
    return "Invoice{" +
        "invoiceNo=" + invoiceNo +
        ", invoiceServiceContractNo=" + invoiceServiceContractNo +
        ", invoiceTutoringHours=" + invoiceTutoringHours +
        ", invoiceDate=" + invoiceDate +
        ", invoiceTutoringDate=" + invoiceTutoringDate +
        ", invoiceCustomerNo=" + invoiceCustomerNo +
        ", invoiceCreationDate=" + invoiceCreationDate +
        '}';
  }
}
