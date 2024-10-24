package com.triagemsys.TriagemSysBackend.hospital.domain.repository;

import com.triagemsys.TriagemSysBackend.hospital.domain.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
