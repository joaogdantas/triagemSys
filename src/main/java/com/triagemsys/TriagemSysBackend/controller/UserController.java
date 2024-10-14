package com.triagemsys.TriagemSysBackend.controller;

import com.triagemsys.TriagemSysBackend.domain.patient.data.ReturnPatientDTO;
import com.triagemsys.TriagemSysBackend.domain.service.UserService;
import com.triagemsys.TriagemSysBackend.domain.user.User;
import com.triagemsys.TriagemSysBackend.domain.user.data.UserDataMe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserDataMe> authenticatedUser() {
        var currentUser = userService.getCurrentUser();

        return ResponseEntity.status(HttpStatus.OK.value()).body(currentUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDataMe> getPatientById(@PathVariable UUID id) {
        UserDataMe userDTO = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.FOUND.value()).body(userDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> allUsers() {
        List <User> users = userService.allUsers();

        return ResponseEntity.status(HttpStatus.OK.value()).body(users);
    }
}