package com.triagemsys.TriagemSysBackend.hospital.domain.treatment.data;

import java.util.Date;
import java.util.UUID;

public record RegisterTreatmentDTO(
        String protocol,
        String priority,
        UUID patientId,
        String type,
        String arrival,
        String wardNumber,
        String bed,
        Date admission,
        Date discharge,
        String bloodPressure,
        String heartRate,
        String respiratoryRate,
        Integer temperature,
        Integer oxygenSaturation,
        Integer bloodSugar,
        String chiefComplaint
) {}
