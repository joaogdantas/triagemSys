package com.triagemsys.TriagemSysBackend.hospital.domain.treatment;


import com.triagemsys.TriagemSysBackend.hospital.domain.patient.Patient;
import com.triagemsys.TriagemSysBackend.hospital.domain.treatment.data.RegisterTreatmentDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "treatments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "protocol")
public class Treatment {
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name="created_by")
    private UUID createdBy;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "protocol")
    private String protocol;
    @Column(name = "priority")
    private String priority;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_id", referencedColumnName="id")
    private Patient patient;
    @Column(name = "type")
    private String type;
    @Column(name = "arrival")
    private String arrival;
    @Column(name = "ward_number")
    private String wardNumber;
    @Column(name = "bed")
    private String bed;
    @Column(name = "admission")
    private Date admission;
    @Column(name = "discharge")
    private Date discharge;
    @Column(name = "blood_pressure")
    private String bloodPressure;
    @Column(name = "heart_rate")
    private String heartRate;
    @Column(name = "respiratory_rate")
    private String respiratoryRate;
    @Column(name = "temperature")
    private Integer temperature;
    @Column(name = "oxygen_saturation")
    private Integer oxygenSaturation;
    @Column(name = "blood_sugar")
    private Integer bloodSugar;
    @Column(name = "chief_complaint")
    private String chiefComplaint;

    public Treatment(RegisterTreatmentDTO registerTreatmentDTO) {
        this.protocol = registerTreatmentDTO.protocol();
        this.priority = registerTreatmentDTO.priority();
        this.type = registerTreatmentDTO.type();
        this.arrival = registerTreatmentDTO.arrival();
        this.wardNumber = registerTreatmentDTO.wardNumber();
        this.bed = registerTreatmentDTO.bed();
        this.admission = registerTreatmentDTO.admission();
        this.discharge = registerTreatmentDTO.discharge();
        this.bloodPressure = registerTreatmentDTO.bloodPressure();
        this.heartRate = registerTreatmentDTO.heartRate();
        this.respiratoryRate = registerTreatmentDTO.respiratoryRate();
        this.temperature = registerTreatmentDTO.temperature();
        this.oxygenSaturation = registerTreatmentDTO.oxygenSaturation();
        this.bloodSugar = registerTreatmentDTO.bloodSugar();
        this.chiefComplaint = registerTreatmentDTO.chiefComplaint();
    }
}
