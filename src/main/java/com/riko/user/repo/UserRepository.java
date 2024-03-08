package com.riko.user.repo;

import com.riko.user.model.User;
import com.riko.user.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndRole(String email, Role role);
    Optional<User> findByIdAndRole(Long id, Role role);
}
