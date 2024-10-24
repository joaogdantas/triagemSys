package com.triagemsys.TriagemSysBackend.autenticacao.controller;

import com.triagemsys.TriagemSysBackend.autenticacao.domain.service.security.AuthenticationService;
import com.triagemsys.TriagemSysBackend.autenticacao.domain.service.security.JwtService;
import com.triagemsys.TriagemSysBackend.autenticacao.domain.user.User;
import com.triagemsys.TriagemSysBackend.autenticacao.domain.user.data.LoginUserDTO;
import com.triagemsys.TriagemSysBackend.autenticacao.domain.user.data.RegisterUserDTO;
import com.triagemsys.TriagemSysBackend.infra.web.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDTO registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.status(HttpStatus.OK.value()).body(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.status(HttpStatus.OK.value()).body(loginResponse);
    }
}
