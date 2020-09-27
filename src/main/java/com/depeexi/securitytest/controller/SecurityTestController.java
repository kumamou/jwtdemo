package com.depeexi.securitytest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("secrity")
public class SecurityTestController {
    @RequestMapping(value = "/protectedadmin", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getProtectedAdmin() {
        return ResponseEntity.ok("Greetings from admin protected method!");
    }

    @RequestMapping(value = "/protecteduser", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getProtectedUser() {
        return ResponseEntity.ok("Greetings from user protected method!");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Greetings from test protected method!");
    }
}
