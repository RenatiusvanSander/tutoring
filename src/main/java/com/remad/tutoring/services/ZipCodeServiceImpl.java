package com.remad.tutoring.services;

import com.remad.tutoring.dao.ZipCodeRepository;
import com.remad.tutoring.models.ZipCode;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Zip code service implementation concerning of creating, deleting and existing.
 */
@Service
public class ZipCodeServiceImpl implements ZipCodeService {

  /**
   * zip code repository for persistence and database operations
   */
  private final ZipCodeRepository zipCodeRepository;

  /**
   * Constructor
   *
   * @param zipCodeRepository zip code repository for persistence and database operations
   */
  public ZipCodeServiceImpl(final ZipCodeRepository zipCodeRepository) {
    this.zipCodeRepository = zipCodeRepository;
  }

  @Override
  public void create(ZipCode zipCode) {
    Example<ZipCode> zipCodeExample = Example.of(ZipCode.from(zipCode));
    Optional<ZipCode> optional = this.zipCodeRepository.findOne(zipCodeExample);

    if (optional.isEmpty()) {
      this.zipCodeRepository.saveAndFlush(zipCode);
    }
  }

  @Override
  public void delete(long id) {
    this.zipCodeRepository.deleteById(id);
  }

  @Override
  public boolean exists(long id) {
    return this.zipCodeRepository.existsById(id);
  }

  @Override
  public ZipCode getZipCode(long id) {
    return this.zipCodeRepository.getReferenceById(id);
  }
}
