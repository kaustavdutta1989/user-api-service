package com.riko.user.controller;

import com.riko.user.model.User;
import com.riko.user.service.UserAuthenticateService;
import com.riko.user.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticateController {

    private final UserAuthenticateService userAuthenticateService;

    @GetMapping("/partner/{email}")
    public ResponseEntity<User> getPartner(@PathVariable String email) {
        return ResponseEntity.ok(userAuthenticateService.authenticatePartner(email));
    }

    @GetMapping("/viewer/{email}")
    public ResponseEntity<User> updateViewer(@PathVariable String email) {
        return ResponseEntity.ok(userAuthenticateService.authenticateViewer(email));
    }
}
