package com.remad.tutoring.services;

import com.remad.tutoring.models.User;
import java.util.Collection;

/**
 * user service interface defines commonly used public methods concerning user. These methods are
 * for creating, updating, deleting and getting all users.
 */
public interface UserService {

  /**
   * Creates user.
   *
   * @param user given user to create and persist
   */
  void createUser(User user);

  /**
   * Updates user.
   *
   * @param id   given numeric identifier of user to update
   * @param user changed user to update
   */
  void updateUser(long id, User user);

  /**
   * Deletes user.
   *
   * @param id given numeric user's identifier to delete user data set
   * @return true / false for user is deleted. Case false means
   */
  boolean deleteUser(long id);

  /**
   * Get users
   *
   * @return returns all persisted users on data base
   */
  Collection<User> getUsers();

  /**
   * Gets user
   *
   * @param id user's numeric identifier to retrieve
   * @return loaded user matching user's identifier
   */
  User getUser(long id);
}
