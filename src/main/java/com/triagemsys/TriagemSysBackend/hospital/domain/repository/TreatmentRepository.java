package com.triagemsys.TriagemSysBackend.hospital.domain.repository;

import com.triagemsys.TriagemSysBackend.hospital.domain.treatment.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TreatmentRepository extends JpaRepository<Treatment, UUID> {
    void deleteByProtocol(String protocol);
    Optional<Treatment> findByProtocol(String protocol);
}
