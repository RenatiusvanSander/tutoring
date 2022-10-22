package com.remad.tutoring.controllers;

import com.remad.tutoring.models.User;
import com.remad.tutoring.services.UserService;
import java.util.Collection;
import java.util.List;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

/**
 * REST controller concerning create, read, update and delete. User resource.
 */
@Controller
@RequestMapping("/users")
public class UserController {

  /**
   * the user service from service layer
   */
  @Autowired
  private final UserService userService;

  /**
   * Constructor
   *
   * @param userService user service implementation for persistence and database access
   */
  public UserController(final UserService userService) {
    this.userService = userService;
  }

  /**
   * Creates user
   *
   * @param userToCreate given user to create user account for
   * @return Returns hyper text protocol status 200 in case of user is created. In case of user
   * creation fails with exception then status 500 internal server error is returned.
   */
  @PostMapping("/create-user")
  public ResponseEntity<Object> createUser(@RequestBody User userToCreate) {
    try {
      this.userService.createUser(userToCreate);

      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User is not created.",
          e);
    }
  }

  /**
   * Gets all users
   *
   * @return all users on database
   */
  @GetMapping("/all-users")
  @ResponseBody
  public ResponseEntity<Collection<User>> getAllUsers() {
    Collection<User> users = this.userService.getUsers();

    return ResponseEntity.ok(users);
  }

  /**
   * Gets user by id
   *
   * @param id user's identifier to load user for
   * @return the loaded user
   */
  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity<User> getUserById(@PathVariable long id) {
    try {
      User user = this.userService.getUser(id);

      return user != null ? ResponseEntity.ok(user)
          : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User is not found.",
          e);
    }
  }

  /**
   * Updates user
   *
   * @param id          user's identifier to update user data
   * @param updatedUser updated user data to persists
   * @return In case of user is updated the HTTP Status is 200. In different case there is internal
   * server error.
   */
  @PutMapping("/{id}")
  public ResponseEntity<Object> updateUser(@PathVariable long id, @RequestBody User updatedUser) {
    try {
      this.userService.updateUser(id, updatedUser);

      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User is not updated.",
          e);
    }
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable long id) {
    try {
      this.userService.deleteUser(id);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User is not deleted.",
          e);
    }
  }
}
