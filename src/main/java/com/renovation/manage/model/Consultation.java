package com.renovation.manage.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "consultations")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long projectId;

    @Column(nullable = false)
    private String residentName;

    @Column(nullable = false)
    private String residentPhone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String opinion;

    @Column(nullable = false)
    private String status;

    private LocalDate consultationDate;

    @Column(length = 1000)
    private String remark;

    private String collector;

    public Consultation() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public String getResidentName() { return residentName; }
    public void setResidentName(String residentName) { this.residentName = residentName; }
    public String getResidentPhone() { return residentPhone; }
    public void setResidentPhone(String residentPhone) { this.residentPhone = residentPhone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getOpinion() { return opinion; }
    public void setOpinion(String opinion) { this.opinion = opinion; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getConsultationDate() { return consultationDate; }
    public void setConsultationDate(LocalDate consultationDate) { this.consultationDate = consultationDate; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public String getCollector() { return collector; }
    public void setCollector(String collector) { this.collector = collector; }
}
