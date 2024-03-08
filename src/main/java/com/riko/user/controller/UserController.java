package com.riko.user.controller;

import com.riko.user.model.User;
import com.riko.user.model.enums.Role;
import com.riko.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/partner/{id}")
    public ResponseEntity<User> getPartnerById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserByIdAndRole(id, Role.PARTNER));
    }

    @GetMapping("/viewer/{id}")
    public ResponseEntity<User> getViewerById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserByIdAndRole(id, Role.VIEWER));
    }
}
