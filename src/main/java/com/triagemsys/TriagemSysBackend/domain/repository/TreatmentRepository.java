package com.triagemsys.TriagemSysBackend.domain.repository;

import com.triagemsys.TriagemSysBackend.domain.patient.Patient;
import com.triagemsys.TriagemSysBackend.domain.treatment.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TreatmentRepository extends JpaRepository<Treatment, UUID> {
    void deleteByProtocol(String protocol);
    Optional<Treatment> findByProtocol(String protocol);
}
