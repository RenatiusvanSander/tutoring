package com.remad.tutoring.dao;

import com.remad.tutoring.models.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Zipcode repository has all methods concerning CRUD-repository and many more.
 */
public interface ZipCodeRepository extends JpaRepository<ZipCode, Long> {

}
