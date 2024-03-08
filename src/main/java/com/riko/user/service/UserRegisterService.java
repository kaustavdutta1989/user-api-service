package com.riko.user.service;

import com.riko.user.model.User;

public interface UserRegisterService {
    User registerUser(User user);
    User updateUser(String email, String name, String phone);
    User updateUserPassword(String email, String password);
}
