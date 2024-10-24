package com.triagemsys.TriagemSysBackend.hospital.domain.service;

import com.triagemsys.TriagemSysBackend.autenticacao.domain.service.UserService;
import com.triagemsys.TriagemSysBackend.hospital.domain.patient.Patient;
import com.triagemsys.TriagemSysBackend.hospital.domain.repository.PatientRepository;
import com.triagemsys.TriagemSysBackend.hospital.domain.repository.TreatmentRepository;
import com.triagemsys.TriagemSysBackend.hospital.domain.treatment.Treatment;
import com.triagemsys.TriagemSysBackend.hospital.domain.treatment.data.RegisterTreatmentDTO;
import com.triagemsys.TriagemSysBackend.hospital.domain.treatment.data.ReturnTreatmentDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UserService userService;

    public Treatment registerTreatment(RegisterTreatmentDTO registerTreatmentDTO) {
        Optional<Patient> findedPatient = patientRepository.findById(registerTreatmentDTO.patientId());

        if(findedPatient.isEmpty()){
            throw new EntityNotFoundException("Paciente não encontrado!");
        }

        Treatment newTreatment = new Treatment(registerTreatmentDTO);
        var currentUser = userService.getCurrentUser();

        newTreatment.setPatient(findedPatient.get());
        newTreatment.setCreatedBy(currentUser.id());
        newTreatment.setCreatedAt(LocalDateTime.now());

        return treatmentRepository.save(newTreatment);
    }

    public List<ReturnTreatmentDTO> findAllTreatments() {
        return treatmentRepository.findAll()
                .stream()
                .map(treatment -> new ReturnTreatmentDTO(
                        treatment.getCreatedAt(), treatment.getCreatedBy(), treatment.getId(), treatment.getProtocol(), treatment.getPatient().getName(), treatment.getPatient().getCpf()))
                .collect(Collectors.toList());
    }

    public ReturnTreatmentDTO getTreatmentByProtocol(String protocol) {
        Treatment treatment = treatmentRepository.findByProtocol(protocol)
                .orElseThrow(() -> new EntityNotFoundException("Tratamento não encontrado!"));
        return new ReturnTreatmentDTO(
                treatment.getCreatedAt(), treatment.getCreatedBy(), treatment.getId(), treatment.getProtocol(), treatment.getPatient().getName(), treatment.getPatient().getCpf()
        );
    }

    public void updateTreatment(UUID id, RegisterTreatmentDTO registerTreatmentDTO) {
        Optional<Treatment> optionalTreatment = treatmentRepository.findById(id);


        if(optionalTreatment.isPresent()) {
            var currentUser = userService.getCurrentUser();

            var treatment = optionalTreatment.get();

            treatment.setCreatedBy(currentUser.id());
            treatment.setCreatedAt(LocalDateTime.now());
            treatment.setPriority(registerTreatmentDTO.priority());
            treatment.setType(registerTreatmentDTO.type());
            treatment.setArrival(registerTreatmentDTO.arrival());
            treatment.setWardNumber(registerTreatmentDTO.wardNumber());
            treatment.setBed(registerTreatmentDTO.bed());
            treatment.setAdmission(registerTreatmentDTO.admission());
            treatment.setDischarge(registerTreatmentDTO.discharge());
            treatment.setBloodPressure(registerTreatmentDTO.bloodPressure());
            treatment.setHeartRate(registerTreatmentDTO.heartRate());
            treatment.setRespiratoryRate(registerTreatmentDTO.respiratoryRate());
            treatment.setTemperature(registerTreatmentDTO.temperature());
            treatment.setOxygenSaturation(registerTreatmentDTO.oxygenSaturation());
            treatment.setBloodSugar(registerTreatmentDTO.bloodSugar());
            treatment.setChiefComplaint(registerTreatmentDTO.chiefComplaint());

            treatmentRepository.save(treatment);
        }
    }

    public void deleteTreatmentById(UUID id){
        treatmentRepository.deleteById(id);
    }

}


