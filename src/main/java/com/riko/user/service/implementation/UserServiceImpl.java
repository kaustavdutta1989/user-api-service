package com.riko.user.service.implementation;

import com.riko.user.model.User;
import com.riko.user.model.enums.Role;
import com.riko.user.repo.UserRepository;
import com.riko.user.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return findUserById(id);
    }

    @Override
    public User getUserByIdAndRole(Long id, Role role) {
        return findUserByIdAndRole(id, role);
    }

    private User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user not found with id: " + id));
    }

    private User findUserByIdAndRole(Long id, Role role) {
        return userRepository.findByIdAndRole(id, role)
                .orElseThrow(() -> new EntityNotFoundException(role + " not found with id: " + id));
    }
}
