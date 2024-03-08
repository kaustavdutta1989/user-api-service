package com.riko.user.service;

import com.riko.user.model.User;
import com.riko.user.model.enums.Role;

public interface UserService {
    User getUser(Long id);
    User getUserByIdAndRole(Long id, Role role);
}
