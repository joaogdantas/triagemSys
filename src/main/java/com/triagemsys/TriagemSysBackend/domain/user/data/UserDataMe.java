package com.triagemsys.TriagemSysBackend.domain.user.data;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public record UserDataMe(
    UUID id,
    String registrationNumber,
    String name,
    String email,
    String password,
    String cpf,
    String role
) {
}
