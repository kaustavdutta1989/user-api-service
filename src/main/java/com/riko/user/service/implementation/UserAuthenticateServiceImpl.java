package com.riko.user.service.implementation;

import com.riko.user.model.User;
import com.riko.user.model.enums.Role;
import com.riko.user.repo.UserRepository;
import com.riko.user.service.UserAuthenticateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserAuthenticateServiceImpl implements UserAuthenticateService {

    private final UserRepository userRepository;

    @Override
    public User authenticatePartner(String email) {
        return getByEmailAndRole(email, Role.PARTNER);
    }

    @Override
    public User authenticateViewer(String email) {
        return getByEmailAndRole(email, Role.VIEWER);
    }

    private User getByEmailAndRole(String email, Role role) {
        return userRepository.findByEmailAndRole(email, role)
                .orElseThrow(() -> {
                    log.error(role + " not found with email: " + email);
                    return new EntityNotFoundException(role + " not found with email: " + email);
                });

    }
}
