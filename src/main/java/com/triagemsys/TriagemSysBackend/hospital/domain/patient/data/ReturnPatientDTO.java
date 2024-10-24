package com.triagemsys.TriagemSysBackend.hospital.domain.patient.data;

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
