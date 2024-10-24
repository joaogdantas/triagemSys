package com.triagemsys.TriagemSysBackend.hospital.domain.patient;

import com.triagemsys.TriagemSysBackend.hospital.domain.patient.data.RegisterPatientDTO;
import com.triagemsys.TriagemSysBackend.hospital.domain.treatment.Treatment;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name="created_by")
    private UUID createdBy;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "name") 
    private String name;
    @Column(name = "birth")
    private String birth;
    @Column(name = "rg")
    private String rg;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "electoral_card")
    private String electoralCard;
    @Column(name = "cns")
    private String cns;
    @Column(name = "mother_name")
    private String motherName;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "address_line_one")
    private String addressLineOne;
    @Column(name = "address_line_two")
    private String addressLineTwo;
    @Column(name = "address_number")
    private String addressNumber;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "cep")
    private String cep;
    @Column(name = "blood_type")
    private String bloodType;
    @Column(name = "is_blood_donor")
    private Boolean isBloodDonor;
    @Column(name = "is_organ_donor")
    private Boolean isOrganDonor;
    @Column(name = "is_bone_marrow_donor")
    private Boolean isBoneMarrowDonor;
    @Column(name = "notes")
    private String notes;
    @OneToMany(mappedBy = "patient")
    private List<Treatment> treatments;

    public Patient(RegisterPatientDTO registerPatientDTO){
        this.name = registerPatientDTO.name();
        this.birth = registerPatientDTO.birth();
        this.rg = registerPatientDTO.rg();
        this.cpf = registerPatientDTO.cpf();
        this.electoralCard = registerPatientDTO.electoralCard();
        this.cns = registerPatientDTO.cns();
        this.motherName = registerPatientDTO.motherName();
        this.fatherName = registerPatientDTO.fatherName();
        this.addressLineOne = registerPatientDTO.addressLineOne();
        this.addressLineTwo = registerPatientDTO.addressLineTwo();
        this.addressNumber = registerPatientDTO.addressNumber();
        this.city = registerPatientDTO.city();
        this.state = registerPatientDTO.state();
        this.cep = registerPatientDTO.cep();
        this.bloodType = registerPatientDTO.bloodType();
        this.isBloodDonor = registerPatientDTO.isBloodDonor();
        this.isOrganDonor = registerPatientDTO.isOrganDonor();
        this.isBoneMarrowDonor = registerPatientDTO.isBoneMarrowDonor();
        this.notes = registerPatientDTO.notes();
    }
}
