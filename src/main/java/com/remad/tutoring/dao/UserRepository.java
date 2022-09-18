package com.remad.tutoring.dao;

import com.remad.tutoring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * user repository has all method concerning CRUD-repository, paging and sorting
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
