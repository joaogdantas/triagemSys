package com.triagemsys.TriagemSysBackend.domain.service;


import com.triagemsys.TriagemSysBackend.domain.patient.Patient;
import com.triagemsys.TriagemSysBackend.domain.patient.data.ReturnPatientDTO;
import com.triagemsys.TriagemSysBackend.domain.repository.UserRepository;
import com.triagemsys.TriagemSysBackend.domain.user.User;
import com.triagemsys.TriagemSysBackend.domain.user.data.UserDataMe;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }

    public UserDataMe getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
        return new UserDataMe(
                user.getId(), user.getRegistrationNumber(), user.getName(), user.getEmail(), user.getCpf(), user.getPassword(), user.getRole());
    }

    public UserDataMe getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return new UserDataMe(currentUser.getId(), currentUser.getRegistrationNumber(), currentUser.getName(), currentUser.getEmail(), currentUser.getPassword(), currentUser.getCpf(), currentUser.getRole());
    }
}
