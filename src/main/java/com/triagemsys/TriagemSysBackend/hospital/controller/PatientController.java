package com.triagemsys.TriagemSysBackend.hospital.controller;

import com.triagemsys.TriagemSysBackend.hospital.domain.patient.Patient;
import com.triagemsys.TriagemSysBackend.hospital.domain.patient.data.RegisterPatientDTO;
import com.triagemsys.TriagemSysBackend.hospital.domain.patient.data.ReturnPatientDTO;
import com.triagemsys.TriagemSysBackend.hospital.domain.repository.PatientRepository;
import com.triagemsys.TriagemSysBackend.hospital.domain.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/register")
    public ResponseEntity registerPatient(@RequestBody RegisterPatientDTO registerPatientDTO) {

        Patient registeredPatient = patientService.registerPatient(registerPatientDTO);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body("Paciente registrado com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnPatientDTO> getPatientById(@PathVariable UUID id) {
        ReturnPatientDTO patientDTO = patientService.getPatientById(id);
        return ResponseEntity.status(HttpStatus.FOUND.value()).body(patientDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReturnPatientDTO>> getAllPatients() {
        List<ReturnPatientDTO> patients = patientService.findAllPatients();
        return ResponseEntity.status(HttpStatus.FOUND.value()).body(patients);
    }

    @PutMapping("update/{id}")
    public ResponseEntity editPatient(@PathVariable UUID id, @RequestBody RegisterPatientDTO registerPatientDTO) {
        Patient updatedPatient = patientService.editPatient(id, registerPatientDTO);
        return ResponseEntity.status(HttpStatus.OK.value()).body("Paciente atualizado com sucesso!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePatientById(@PathVariable UUID id) {
        patientService.deletePatientById(id);
        return ResponseEntity.status(HttpStatus.OK.value()).body("Paciente deletado com sucesso!");
    }
}

