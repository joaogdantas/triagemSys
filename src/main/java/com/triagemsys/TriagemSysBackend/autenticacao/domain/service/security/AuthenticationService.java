package com.triagemsys.TriagemSysBackend.autenticacao.domain.service.security;

import com.triagemsys.TriagemSysBackend.autenticacao.domain.repository.UserRepository;
import com.triagemsys.TriagemSysBackend.autenticacao.domain.user.User;
import com.triagemsys.TriagemSysBackend.autenticacao.domain.user.data.LoginUserDTO;
import com.triagemsys.TriagemSysBackend.autenticacao.domain.user.data.RegisterUserDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDTO input) {
        User user = new User();

        user.setRegistrationNumber(input.registrationNumber());
        user.setName(input.name());
        user.setEmail(input.email());
        user.setPassword(passwordEncoder.encode(input.password()));
        user.setCpf(input.cpf());
        user.setRole(input.role());

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.password()
                )
        );

        return userRepository.findByEmail(input.email())
                .orElseThrow();
    }
}
