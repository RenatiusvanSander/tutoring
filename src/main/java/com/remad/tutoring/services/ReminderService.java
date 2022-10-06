package com.remad.tutoring.services;

import com.remad.tutoring.models.Reminder;
import java.util.Collection;

/**
 * reminder service concerning creation, deletion, update and get.
 */
public interface ReminderService {

  /**
   * Creates reminder.
   *
   * @param reminder reminder to store on database
   */
  void createReminder(Reminder reminder);

  /**
   * Update reminder
   *
   * @param id       reminder's numeric identifier to update matching dataset
   * @param reminder reminder with updated data
   */
  void updateReminder(long id, Reminder reminder);

  /**
   * Deletes reminder
   *
   * @param id reminder#s numeric identifier to delete matching dataset
   */
  void deleteReminder(long id);

  /**
   * Gets a reminder.
   *
   * @param id reminder's numeric identifier to get matching dataset
   * @return matching reminder
   */
  Reminder getReminder(long id);

  /**
   * Gets all reminders.
   *
   * @return all reminders
   */
  Collection<Reminder> getReminders();
}
