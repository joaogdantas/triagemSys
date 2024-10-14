package com.triagemsys.TriagemSysBackend.domain.user.data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserDTO(

        @NotBlank(message = "O número de matrícula é obrigatório.")
        String registrationNumber,

        @NotBlank(message = "O nome é obrigatório.")
        String name,

        @NotBlank(message = "O email é obrigatório.")
        @Email(message = "Formato de email inválido.")
        String email,

        @NotBlank(message = "A senha é obrigatória.")
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
        String password,

        @NotBlank(message = "O CPF é obrigatório.")
        @Size(min = 11, max = 11, message = "O CPF deve ter 11 caracteres.")
        String cpf,

        @NotBlank(message = "O papel do usuário é obrigatório.")
        String role
) {}
