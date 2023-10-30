package com.sha.serverproductmanagement.repository;

import com.sha.serverproductmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
