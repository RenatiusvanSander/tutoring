package com.remad.tutoring.services;

import com.remad.tutoring.models.TutoringAppointment;
import java.util.Collection;

/**
 * service for tutoring appointments
 */
public interface TutoringAppointmentService {

  /**
   * Creates an appointment.
   *
   * @param tutoringAppointment tutoring appoinment to create
   */
  void createTutoringAppointment(TutoringAppointment tutoringAppointment);

  /**
   * Updates tutoring appointment
   *
   * @param id                  tutoring appointment's numeric identifier to update dataset
   * @param tutoringAppointment tutoring appointment holds updated data
   */
  void updateTutoringAppointment(long id, TutoringAppointment tutoringAppointment);

  /**
   * Deletes an appointment
   *
   * @param id numeric tutoring appointment to delete for
   */
  void deleteTutoringAppointment(long id);

  /**
   * Gets tutoring appointment
   *
   * @param id numeric identifier of tutoring appointment to get
   * @return the matching tutoring appointment
   */
  TutoringAppointment getTutoringAppointment(long id);

  /**
   * Gets all tutoring appointments
   *
   * @return tutoring appointments, {@link TutoringAppointment}
   */
  Collection<TutoringAppointment> getTutoringAppointments();
}
