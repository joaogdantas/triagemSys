package com.triagemsys.TriagemSysBackend.domain.patient.data;

import com.triagemsys.TriagemSysBackend.domain.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReturnPatientDTO(
        LocalDateTime createdAt,
        UUID createdBy,
        UUID id,
        String name,
        String city,
        String state
){}
