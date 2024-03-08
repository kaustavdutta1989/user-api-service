package com.riko.user.controller;

import com.riko.user.model.User;
import com.riko.user.model.enums.Role;
import com.riko.user.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/revamp")
public class RevampController {

    private final UserRegisterService userRegisterService;

    @PatchMapping("/partner")
    public ResponseEntity<User> updatePartner(@RequestBody User user) {
        return ResponseEntity.ok(userRegisterService.updateUser(user.getEmail(), user.getName(), user.getPhone()));
    }

    @PatchMapping("/viewer")
    public ResponseEntity<User> updateViewer(@RequestBody User user) {
        return ResponseEntity.ok(userRegisterService.updateUser(user.getEmail(), user.getName(), user.getPhone()));
    }

    @PatchMapping("/forgot-password")
    public ResponseEntity<User> updatePassword(@RequestBody User user) {
        return ResponseEntity.ok(userRegisterService.updateUserPassword(user.getEmail(), user.getPassword()));
    }
}
