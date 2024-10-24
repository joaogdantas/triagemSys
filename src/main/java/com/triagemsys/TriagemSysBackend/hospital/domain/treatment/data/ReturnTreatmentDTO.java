package com.triagemsys.TriagemSysBackend.hospital.domain.treatment.data;

import java.time.LocalDateTime;
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
