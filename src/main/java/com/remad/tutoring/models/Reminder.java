package com.remad.tutoring.models;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Reminder represents calendar reminder of a tutoring appointment.
 */
@Entity
public class Reminder {

  /**
   * reminder number as primary key of a data set of 'Reminder'
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "reminder_no")
  private long reminderNo;
  /**
   * reminder's tutoring appointment number
   */
  // TODO mapping to appointment
  private long reminderTutoringAppointmentNo;
  /**
   * reminder's customer number
   */
  // TODO mapping to customer no
  private long reminderCustomerNo;
  /**
   * reminder's date
   */
  @Column(name = "reminder_date", columnDefinition = "TIMESTAMP")
  private LocalDateTime reminderDate;
  /**
   * reminder's creation date of data set
   */
  @Column(name = "reminder_creation_date", columnDefinition = "TIMESTAMP")
  private LocalDateTime reminderCreationDate;

  /**
   * Constructor
   */
  public Reminder() {
  }

  /**
   * Constructor
   *
   * @param reminderNo                    reminder's number
   * @param reminderTutoringAppointmentNo reminder's tutoring appointment number
   * @param reminderCustomerNo            reminder's customer number
   * @param reminderDate                  reminder's date
   * @param reminderCreationDate          reminder's creation date
   */
  public Reminder(long reminderNo, long reminderTutoringAppointmentNo, long reminderCustomerNo,
      LocalDateTime reminderDate, LocalDateTime reminderCreationDate) {
    this.reminderNo = reminderNo;
    this.reminderTutoringAppointmentNo = reminderTutoringAppointmentNo;
    this.reminderCustomerNo = reminderCustomerNo;
    this.reminderDate = reminderDate;
    this.reminderCreationDate = reminderCreationDate;
  }

  public long getReminderNo() {
    return reminderNo;
  }

  public void setReminderNo(long reminderNo) {
    this.reminderNo = reminderNo;
  }

  public long getReminderTutoringAppointmentNo() {
    return reminderTutoringAppointmentNo;
  }

  public void setReminderTutoringAppointmentNo(long reminderTutoringAppointmentNo) {
    this.reminderTutoringAppointmentNo = reminderTutoringAppointmentNo;
  }

  public long getReminderCustomerNo() {
    return reminderCustomerNo;
  }

  public void setReminderCustomerNo(long reminderCustomerNo) {
    this.reminderCustomerNo = reminderCustomerNo;
  }

  public LocalDateTime getReminderDate() {
    return reminderDate;
  }

  public void setReminderDate(LocalDateTime reminderDate) {
    this.reminderDate = reminderDate;
  }

  public LocalDateTime getReminderCreationDate() {
    return reminderCreationDate;
  }

  public void setReminderCreationDate(LocalDateTime reminderCreationDate) {
    this.reminderCreationDate = reminderCreationDate;
  }

  @Override
  public int hashCode() {
    return Objects.hash(reminderNo, reminderTutoringAppointmentNo, reminderCustomerNo, reminderDate,
        reminderCreationDate);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Reminder)) {
      return false;
    }

    Reminder reminder = (Reminder) o;
    return reminderNo == reminder.reminderNo
        && reminderTutoringAppointmentNo == reminder.reminderTutoringAppointmentNo
        && reminderCustomerNo == reminder.reminderCustomerNo && reminderDate.equals(
        reminder.reminderDate) && reminderCreationDate.equals(reminder.reminderCreationDate);
  }

  @Override
  public String toString() {
    return "Reminder{" +
        "reminderNo=" + reminderNo +
        ", reminderTutoringAppointmentNo=" + reminderTutoringAppointmentNo +
        ", reminderCustomerNo=" + reminderCustomerNo +
        ", reminderDate=" + reminderDate +
        ", reminderCreationDate=" + reminderCreationDate +
        '}';
  }
}
