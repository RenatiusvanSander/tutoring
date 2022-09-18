package com.remad.tutoring.dao;

import com.remad.tutoring.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Invoice repository has all methods concerning paging, sorting and CRUD-operation
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
