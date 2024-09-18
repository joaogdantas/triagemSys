package com.triagemsys.TriagemSysBackend.domain.service;

import com.triagemsys.TriagemSysBackend.domain.patient.Patient;
import com.triagemsys.TriagemSysBackend.domain.patient.data.RegisterPatientDTO;
import com.triagemsys.TriagemSysBackend.domain.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient registerPatient(RegisterPatientDTO registerPatientDTO) {
        Patient newPatient = new Patient(registerPatientDTO);
        return patientRepository.save(newPatient);
    }
}
