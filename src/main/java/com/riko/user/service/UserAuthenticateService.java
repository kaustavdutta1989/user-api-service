package com.riko.user.service;

import com.riko.user.model.User;
import com.riko.user.model.enums.Role;

public interface UserAuthenticateService {
    User authenticatePartner(String email);
    User authenticateViewer(String email);
}
