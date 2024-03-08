package com.riko.user.controller;

import com.riko.user.model.User;
import com.riko.user.model.enums.Role;
import com.riko.user.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {

    private final UserRegisterService userRegisterService;

    @PostMapping("/partner")
    public ResponseEntity<User> registerPartner(@RequestBody User user) {
        user.setRole(Role.PARTNER);
        return ResponseEntity.ok(userRegisterService.registerUser(user));
    }

    @PostMapping("/viewer")
    public ResponseEntity<User> registerViewer(@RequestBody User user) {
        user.setRole(Role.VIEWER);
        return ResponseEntity.ok(userRegisterService.registerUser(user));
    }
}
