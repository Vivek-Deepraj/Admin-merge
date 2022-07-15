package com.discom.springmvc.controller;

import com.discom.springmvc.dao.SearchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/me")
public class UserController {

    @Autowired
    SearchDao searchDao;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Principal> get(final Principal principal) {
        System.out.print("Candidate /me: " + principal);
        return ResponseEntity.ok(principal);
    }


}