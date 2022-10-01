package com.remad.tutoring.services;

import com.remad.tutoring.dao.UserRepository;
import com.remad.tutoring.models.User;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 * Service implementation for user concerning operations like create, delete, update and get all
 * users.
 */
@Service
public class UserServiceImpl implements UserService {

  /**
   * user repository for database operations
   */
  private final UserRepository userRepository;

  /**
   * Constructor
   *
   * @param userRepository user repository for database operations
   */
  public UserServiceImpl(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void createUser(User user) {
    this.userRepository.saveAndFlush(user);
  }

  @Override
  public void updateUser(long id, User user) {
    User userToUpdate = this.userRepository.getReferenceById(id);

    if (!userToUpdate.equals(user)) {
      userToUpdate.setUserEmail(user.getUserEmail());
      userToUpdate.setUserName(user.getUserName());
      userToUpdate.setUserPassword(user.getUserPassword());
      userToUpdate.setUserCreationDate(user.getUserCreationDate());
    }
  }

  @Override
  public boolean deleteUser(long id) {
    boolean deleted = this.userRepository.existsById(id);
    this.userRepository.deleteById(id);

    return deleted;
  }

  @Override
  public Collection<User> getUsers() {
    return this.userRepository.findAll();
  }

  @Override
  public User getUser(long id) {
    return this.userRepository.getReferenceById(id);
  }
}
