package com.triagemsys.TriagemSysBackend.autenticacao.domain.user.data;

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
