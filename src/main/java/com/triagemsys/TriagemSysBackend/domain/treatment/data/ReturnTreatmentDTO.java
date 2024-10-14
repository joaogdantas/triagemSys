package com.triagemsys.TriagemSysBackend.domain.treatment.data;

import com.triagemsys.TriagemSysBackend.domain.user.User;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public record ReturnTreatmentDTO(
        LocalDateTime createdAt,
        UUID createdBy,
        UUID id,
        String protocol,
        String patientName,
        String cpf
) {
}
