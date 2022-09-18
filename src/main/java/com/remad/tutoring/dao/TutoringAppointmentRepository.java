package com.remad.tutoring.dao;

import com.remad.tutoring.models.TutoringAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Tutoring appointment has all function concerning a crud-repository
 */
public interface TutoringAppointmentRepository extends JpaRepository<TutoringAppointment, Long> {

}
