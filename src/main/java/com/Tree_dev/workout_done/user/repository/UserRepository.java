package com.Tree_dev.workout_done.user.repository;

import com.Tree_dev.workout_done.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email LIKE '%@gmail.com'")
    List<User> findByEmailEndingWith(String email);
}
