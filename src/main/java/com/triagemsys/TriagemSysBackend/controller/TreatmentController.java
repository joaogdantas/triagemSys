package com.triagemsys.TriagemSysBackend.controller;

import com.triagemsys.TriagemSysBackend.domain.service.TreatmentService;
import com.triagemsys.TriagemSysBackend.domain.treatment.data.RegisterTreatmentDTO;
import com.triagemsys.TriagemSysBackend.domain.treatment.data.ReturnTreatmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/treatments")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    @PostMapping("/register")
    public ResponseEntity<String> registerTreatment(@RequestBody RegisterTreatmentDTO registerTreatmentDTO) {
        treatmentService.registerTreatment(registerTreatmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Atendimento registrado com sucesso!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReturnTreatmentDTO>> getAllTreatments() {
        List<ReturnTreatmentDTO> treatments = treatmentService.findAllTreatments();
        return ResponseEntity.status(HttpStatus.FOUND.value()).body(treatments);
    }

    @GetMapping("/{protocol}")
    public ResponseEntity<ReturnTreatmentDTO> getTreatmentByProtocol(@PathVariable String protocol) {
        ReturnTreatmentDTO treatment = treatmentService.getTreatmentByProtocol(protocol);
        return ResponseEntity.status(HttpStatus.FOUND.value()).body(treatment);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTreatment(
            @PathVariable UUID id,
            @RequestBody RegisterTreatmentDTO registerTreatmentDTO) {
        treatmentService.updateTreatment(id, registerTreatmentDTO);
        return ResponseEntity.status(HttpStatus.OK.value()).body("Registro de atendimento atualizado com sucesso!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTreatment(@PathVariable UUID id) {
        treatmentService.deleteTreatmentById(id);
        return ResponseEntity.status(HttpStatus.OK.value()).body("Registro de atendimento deletado com sucesso!");
    }
}

