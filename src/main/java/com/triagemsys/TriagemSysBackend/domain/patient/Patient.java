package com.triagemsys.TriagemSysBackend.domain.patient;

import com.triagemsys.TriagemSysBackend.domain.patient.data.RegisterPatientDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "birth")
    private String birth;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "healthInsurance")
    private String healthInsurance;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;

    public Patient(RegisterPatientDTO registerPatientDTO){
        this.name = registerPatientDTO.name();
        this.birth = registerPatientDTO.birth();
        this.cpf = registerPatientDTO.cpf();
        this.healthInsurance = registerPatientDTO.healthInsurance();
        this.city = registerPatientDTO.city();
        this.state = registerPatientDTO.state();
    }
}
