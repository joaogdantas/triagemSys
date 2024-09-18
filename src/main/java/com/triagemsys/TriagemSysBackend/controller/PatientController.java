package com.triagemsys.TriagemSysBackend.controller;

import com.triagemsys.TriagemSysBackend.domain.patient.Patient;
import com.triagemsys.TriagemSysBackend.domain.patient.data.RegisterPatientDTO;
import com.triagemsys.TriagemSysBackend.domain.repository.PatientRepository;
import com.triagemsys.TriagemSysBackend.domain.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerPatient(@RequestBody RegisterPatientDTO registerPatientDTO) {

        Patient registeredPatient = patientService.registerPatient(registerPatientDTO);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body("Paciente registrado com sucesso!");
    }
}

