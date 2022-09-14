package com.remad.tutoring.models;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A real user in universe of the tutoring app.
 */
@Entity
public class User {

  /**
   * Constructor
   */
  public User() {
  }

  /**
   * Constructor
   *
   * @param userNo           user number
   * @param userName         user's name
   * @param userPassword     use's password
   * @param userEmail        user's e-mail
   * @param userCreationDate user's creation date
   */
  public User(long userNo, String userName, String userPassword, String userEmail,
      LocalDateTime userCreationDate) {
    this.userNo = userNo;
    this.userName = userName;
    this.userPassword = userPassword;
    this.userEmail = userEmail;
    this.userCreationDate = userCreationDate;
  }

  /**
   * Gets user's number
   *
   * @return user's number as primary key
   */
  public long getUserNo() {
    return userNo;
  }

  /**
   * Sets user's number as primary key
   *
   * @param userNo user's number as primary key to set
   */
  public void setUserNo(long userNo) {
    this.userNo = userNo;
  }

  /**
   * Gets user's name
   *
   * @return user's name
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Sets user's name
   *
   * @param userName user's name to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Gets user's password
   *
   * @return user's password
   */
  public String getUserPassword() {
    return userPassword;
  }

  /**
   * Sets user's password
   *
   * @param userPassword user's password to set
   */
  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  /**
   * Gets user's e-mail
   *
   * @return user's e-mail
   */
  public String getUserEmail() {
    return userEmail;
  }

  /**
   * Sets user's email
   *
   * @param userEmail user's email to set
   */
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  /**
   * Gets user's creation date
   *
   * @return user's creation date
   */
  public LocalDateTime getUserCreationDate() {
    return userCreationDate;
  }

  /**
   * Sets user's creation date
   *
   * @param userCreationDate user's creation date to set as timestamp
   */
  public void setUserCreationDate(LocalDateTime userCreationDate) {
    this.userCreationDate = userCreationDate;
  }

  /**
   * userNo, as synonym unique primary key, for a data set
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userNo;

  /**
   * user's name
   */
  private String userName;

  /**
   * user's password
   */
  private String userPassword;

  /**
   * the user's e-mail
   */
  private String userEmail;

  /**
   * creation date of this data set
   */
  @Column(name = "user_creation_date", columnDefinition = "TIMESTAMP")
  private LocalDateTime userCreationDate;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof User)) {
      return false;
    }

    User user = (User) o;
    return getUserNo() == user.getUserNo() && getUserName().equals(user.getUserName())
        && getUserPassword().equals(user.getUserPassword()) && getUserEmail().equals(
        user.getUserEmail()) && getUserCreationDate().equals(user.getUserCreationDate());
  }

  @Override
  public String toString() {
    return "User{" +
        "userNo=" + userNo +
        ", userName='" + userName + '\'' +
        ", userPassword='" + userPassword + '\'' +
        ", userEmail='" + userEmail + '\'' +
        ", userCreationDate=" + userCreationDate +
        '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUserNo(), getUserName(), getUserPassword(), getUserEmail(),
        getUserCreationDate());
  }
}
