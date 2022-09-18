package com.remad.tutoring.dao;

import com.remad.tutoring.models.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * reminder repository has all method concerning a CRUD-operations
 */
public interface ReminderRepository extends JpaRepository<Reminder, Long> {

}
