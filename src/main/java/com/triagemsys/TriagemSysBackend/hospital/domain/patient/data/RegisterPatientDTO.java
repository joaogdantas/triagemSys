package com.triagemsys.TriagemSysBackend.hospital.domain.patient.data;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterPatientDTO(
        @NotNull(message = "O nome não pode ser deixado em branco")
        String name,
        @NotNull(message = "A data de nascimento não pode ser deixada em branco")
        String birth,
        String rg,
        @NotNull(message = "O CPF não pode ser deixado em branco")
        @Size(min = 11, max = 11, message = "O CPF precisa ter 11 números e ser escrito sem pontuação")
        String cpf,
        String electoralCard,
        @NotNull(message = "O número do CNS não pode ser deixado em branco")
        String cns,
        @NotNull(message = "O nome da mãe não pode ser deixado em branco")
        String motherName,
        String fatherName,
        @NotNull(message = "O endereço não pode ser deixado em branco")
        String addressLineOne,
        @NotNull(message = "O endereço não pode ser deixado em branco")
        String addressLineTwo,
        @NotNull(message = "O endereço não pode ser deixado em branco")
        String addressNumber,
        @NotNull(message = "O endereço não pode ser deixado em branco")
        String city,
        @NotNull(message = "O endereço não pode ser deixado em branco")
        String state,
        @NotNull(message = "O endereço não pode ser deixado em branco")
        String cep,
        @NotNull(message = "O tipo sanguíneo não pode ser deixado em branco")
        String bloodType,
        Boolean isBloodDonor,
        Boolean isOrganDonor,
        Boolean isBoneMarrowDonor,
        String notes
){}

