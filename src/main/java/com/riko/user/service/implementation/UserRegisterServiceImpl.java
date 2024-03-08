package com.riko.user.service.implementation;

import com.riko.user.model.User;
import com.riko.user.repo.UserRepository;
import com.riko.user.service.UserRegisterService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserRegisterServiceImpl implements UserRegisterService {

    private final UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return saveUser(user);
    }

    @Override
    public User updateUser(String email, String name, String phone) {
        User foundUser = getByEmail(email);
        foundUser.setName(name);
        foundUser.setPhone(phone);
        return saveUser(foundUser);
    }

    @Override
    public User updateUserPassword(String email, String password) {
        User foundUser = getByEmail(email);
        foundUser.setPassword(password);
        return saveUser(foundUser);
    }

    private User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    log.error("user not found with email: " + email);
                    return new EntityNotFoundException("user not found with email: " + email);
                });

    }

    private User saveUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
