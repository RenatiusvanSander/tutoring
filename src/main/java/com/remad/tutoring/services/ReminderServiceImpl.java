package com.remad.tutoring.services;

import com.remad.tutoring.dao.ReminderRepository;
import com.remad.tutoring.models.Reminder;
import java.util.Collection;

/**
 * Implementation of {@link ReminderService} concerning for creating, updating, getting and deleting
 * a reminder.
 */
public class ReminderServiceImpl implements ReminderService {

  /**
   * tutoring appoint service to get appointment specific data
   */
  private final TutoringAppointmentService tutoringAppointmentService;

  /**
   * customer service to get customer specific data
   */
  private final CustomerService customerService;

  /**
   * reminder repository to save, update, delete and get a {@link Reminder}.
   */
  private final ReminderRepository reminderRepository;

  /**
   * ReminderServiceImpl Constructor
   *
   * @param tutoringAppointmentService tutoring appointment service for appointment operations
   * @param customerService            customer service for customer operation
   * @param reminderRepository         reminder repository concerning create, update, delete and
   *                                   get
   */
  public ReminderServiceImpl(final TutoringAppointmentService tutoringAppointmentService,
      final CustomerService customerService, final ReminderRepository reminderRepository) {
    this.tutoringAppointmentService = tutoringAppointmentService;
    this.customerService = customerService;
    this.reminderRepository = reminderRepository;
  }

  @Override
  public void createReminder(Reminder reminder) {
    this.reminderRepository.saveAndFlush(reminder);
  }

  @Override
  public void updateReminder(long id, Reminder reminder) {
    Reminder reminderToUpdate = this.reminderRepository.getReferenceById(id);

    if (!reminderToUpdate.equals(reminder)) {
      reminderToUpdate.setReminderCustomer(reminder.getReminderCustomer());
      reminderToUpdate.setReminderDate(reminder.getReminderDate());
      reminderToUpdate.setReminderCreationDate(reminder.getReminderCreationDate());
      reminderToUpdate.setReminderTutoringAppointment(reminder.getReminderTutoringAppointment());

      this.reminderRepository.saveAndFlush(reminderToUpdate);
    }
  }

  @Override
  public void deleteReminder(long id) {
    this.reminderRepository.deleteById(id);
  }

  @Override
  public Reminder getReminder(long id) {
    return this.reminderRepository.getReferenceById(id);
  }

  @Override
  public Collection<Reminder> getReminders() {
    return this.reminderRepository.findAll();
  }
}
