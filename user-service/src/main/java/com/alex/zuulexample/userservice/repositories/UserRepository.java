package com.alex.zuulexample.userservice.repositories;

import com.alex.zuulexample.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
