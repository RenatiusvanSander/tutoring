package com.remad.tutoring.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import com.remad.tutoring.models.User;
import com.remad.tutoring.services.UserService;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
public class UserControllerTest {

  /**
   * mocked address controller for tests
   */
  @Autowired
  private MockMvc mockedController;

  /**
   * mocked user service
   */
  @MockBean
  private UserService mockedUserService;

  @Test
  public void testCreateUser() throws Exception {
    User userToCreate = new User("RemyMeier", "12345678", "dd@delete.eu", LocalDateTime.now());

    MockHttpServletResponse actualResponse = mockedController.perform(
            post("/users/create-user", userToCreate).contentType(MediaType.APPLICATION_JSON)
                .content(TestTools.getObjectMapper().writeValueAsString(userToCreate))
                .characterEncoding(StandardCharsets.UTF_8))
        .andReturn()
        .getResponse();

    assertEquals(200, actualResponse.getStatus());
  }

  @Test
  public void testGetAllUsers() throws Exception {
    Collection<User> users = Arrays.asList(
        new User("RemyMeier", "12345678", "dd@delete.eu", LocalDateTime.now()),
        new User("Goofy", "12345678", "goofy@disney.com", LocalDateTime.now()));
    String expectedContent = TestTools.responseEntityBodyToJsonString(ResponseEntity.ok(users));

    when(mockedUserService.getUsers()).thenReturn(users);
    MockHttpServletResponse actualResponse = mockedController.perform(
            get("/users/all-users"))
        .andReturn()
        .getResponse();

    assertEquals(200, actualResponse.getStatus());
    assertEquals(expectedContent, actualResponse.getContentAsString());
  }

  @Test
  public void testGetUserById() throws Exception {
    long pathVariable = 1L;
    User expectedUser = new User("RemyMeier", "12345678", "dd@delete.eu", LocalDateTime.now());
    String expectedContent = TestTools.responseEntityBodyToJsonString(
        ResponseEntity.ok(expectedUser));

    when(mockedUserService.getUser(pathVariable)).thenReturn(expectedUser);
    MockHttpServletResponse actualResponse = mockedController.perform(
            get("/users/{id}", pathVariable))
        .andReturn()
        .getResponse();

    assertEquals(200, actualResponse.getStatus());
    assertEquals(expectedContent, actualResponse.getContentAsString());
  }

  @Test
  public void testUpdateUser() throws Exception {
    User expectedUser = new User(
        "RemyMeier",
        "12345678",
        "dd@delete.eu",
        LocalDateTime.now());
    String expectedContent = TestTools.responseEntityBodyToJsonString(
        ResponseEntity.ok(expectedUser));
    String json = TestTools.getObjectMapper().writeValueAsString(expectedUser);

    MockHttpServletResponse actualResponse = mockedController.perform(
            put("/users/{id}", 3L, expectedUser).contentType(MediaType.APPLICATION_JSON).content(json).characterEncoding(StandardCharsets.UTF_8))
        .andReturn()
        .getResponse();

    assertEquals(200, actualResponse.getStatus());
  }

  @Test
  public void testDeleteUser() throws Exception {
    MockHttpServletResponse actualResponse = mockedController.perform(
            delete("/users/{id}", 3L))
        .andReturn()
        .getResponse();

    assertEquals(200, actualResponse.getStatus());
  }
}
