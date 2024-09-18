package com.triagemsys.TriagemSysBackend.domain.patient.data;

public record RegisterPatientDTO(
        String name,
        String birth,
        String cpf,
        String healthInsurance,
        String city,
        String state
)
{}
