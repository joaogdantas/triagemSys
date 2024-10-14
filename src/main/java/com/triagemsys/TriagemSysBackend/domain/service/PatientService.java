package com.triagemsys.TriagemSysBackend.domain.service;

import com.triagemsys.TriagemSysBackend.domain.patient.Patient;
import com.triagemsys.TriagemSysBackend.domain.patient.data.RegisterPatientDTO;
import com.triagemsys.TriagemSysBackend.domain.patient.data.ReturnPatientDTO;
import com.triagemsys.TriagemSysBackend.domain.repository.PatientRepository;
import com.triagemsys.TriagemSysBackend.domain.repository.UserRepository;
import com.triagemsys.TriagemSysBackend.domain.user.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private User currentUser;

    public Patient registerPatient(RegisterPatientDTO registerPatientDTO) {

        Patient newPatient = new Patient(registerPatientDTO);


        var currentUser = userService.getCurrentUser();

        newPatient.setCreatedBy(currentUser.id());
        newPatient.setCreatedAt(LocalDateTime.now());

        return patientRepository.save(newPatient);
    }

    public List<ReturnPatientDTO> findAllPatients(){
        return patientRepository.findAll()
                .stream()
                .map(patientData -> new ReturnPatientDTO(patientData.getCreatedAt(), patientData.getCreatedBy(), patientData.getId(), patientData.getName(), patientData.getCity(), patientData.getState()))
                .collect(Collectors.toList());
    }

    public ReturnPatientDTO getPatientById(UUID id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado!"));
        return new ReturnPatientDTO(
                patient.getCreatedAt(), patient.getCreatedBy(), patient.getId(), patient.getName(), patient.getCity(), patient.getState()
        );
    }

    public Patient editPatient(UUID id, RegisterPatientDTO registerPatientDTO) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado!"));

        var currentUser = userService.getCurrentUser();

        patient.setCreatedBy(currentUser.id());
        patient.setCreatedAt(LocalDateTime.now());
        patient.setName(registerPatientDTO.name());
        patient.setBirth(registerPatientDTO.birth());
        patient.setRg(registerPatientDTO.rg());
        patient.setCpf(registerPatientDTO.cpf());
        patient.setElectoralCard(registerPatientDTO.electoralCard());
        patient.setCns(registerPatientDTO.cns());
        patient.setMotherName(registerPatientDTO.motherName());
        patient.setFatherName(registerPatientDTO.fatherName());
        patient.setAddressLineOne(registerPatientDTO.addressLineOne());
        patient.setAddressLineTwo(registerPatientDTO.addressLineTwo());
        patient.setAddressNumber(registerPatientDTO.addressNumber());
        patient.setState(registerPatientDTO.state());
        patient.setCep(registerPatientDTO.cep());
        patient.setBloodType(registerPatientDTO.bloodType());
        patient.setIsBloodDonor(registerPatientDTO.isBloodDonor());
        patient.setIsOrganDonor(registerPatientDTO.isOrganDonor());
        patient.setIsBoneMarrowDonor(registerPatientDTO.isBoneMarrowDonor());
        patient.setNotes(registerPatientDTO.notes());

        return patientRepository.save(patient);
    }

    public void deletePatientById(UUID id){
        patientRepository.deleteById(id);
    }
}
