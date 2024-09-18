package com.triagemsys.TriagemSysBackend.domain.repository;

import com.triagemsys.TriagemSysBackend.domain.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
