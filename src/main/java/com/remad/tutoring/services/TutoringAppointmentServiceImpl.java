package com.remad.tutoring.services;

import com.remad.tutoring.dao.TutoringAppointmentRepository;
import com.remad.tutoring.models.TutoringAppointment;
import java.util.Collection;

/**
 * Tutoring appointment service concerning creating, deleting, updating and getting tutoring
 * appointments.
 */
public class TutoringAppointmentServiceImpl implements TutoringAppointmentService {

  /**
   * customer service to get customer data
   */
  private final CustomerService customerService;

  /**
   * tutoring appointment repository for persistence and database operations
   */
  private final
  TutoringAppointmentRepository tutoringAppointmentRepository;

  /**
   * TutoringAppointmentServiceImpl Constructor
   *
   * @param customerService               customer service to process customer data
   * @param tutoringAppointmentRepository tutoring appointment repository concerning database
   *                                      operations
   */
  public TutoringAppointmentServiceImpl(final CustomerService customerService, final
  TutoringAppointmentRepository tutoringAppointmentRepository) {
    this.customerService = customerService;
    this.tutoringAppointmentRepository = tutoringAppointmentRepository;
  }

  @Override
  public void createTutoringAppointment(TutoringAppointment tutoringAppointment) {
    this.tutoringAppointmentRepository.save(tutoringAppointment);
  }

  @Override
  public void updateTutoringAppointment(long id, TutoringAppointment tutoringAppointment) {
    TutoringAppointment tutoringAppointmentToUpdate = this.tutoringAppointmentRepository.getReferenceById(
        id);

    if (!tutoringAppointmentToUpdate.equals(tutoringAppointment)) {
      tutoringAppointmentToUpdate.setTutoringAppointmentCustomer(
          tutoringAppointment.getTutoringAppointmentCustomer());
      tutoringAppointmentToUpdate.setTutoringAppointmentDate(
          tutoringAppointment.getTutoringAppointmentDate());
      tutoringAppointmentToUpdate.setTutoringAppointmentDateTime(
          tutoringAppointment.getTutoringAppointmentDateTime());
      tutoringAppointmentToUpdate.setTutoringAppointmentCreationDate(
          tutoringAppointment.getTutoringAppointmentCreationDate());

      this.tutoringAppointmentRepository.save(tutoringAppointmentToUpdate);
    }
  }

  @Override
  public void deleteTutoringAppointment(long id) {
    this.tutoringAppointmentRepository.deleteById(id);
  }

  @Override
  public TutoringAppointment getTutoringAppointment(long id) {
    return this.tutoringAppointmentRepository.getReferenceById(id);
  }

  @Override
  public Collection<TutoringAppointment> getTutoringAppointments() {
    return this.tutoringAppointmentRepository.findAll();
  }
}
