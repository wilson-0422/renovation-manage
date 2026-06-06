package com.renovation.manage.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "maintenance_visits")
public class MaintenanceVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long projectId;

    @Column(nullable = false)
    private String visitType;

    @Column(nullable = false)
    private String visitorName;

    private String visitorPhone;

    @Column(nullable = false)
    private String visitResult;

    @Column(length = 2000)
    private String feedback;

    private LocalDate visitDate;

    private LocalDate nextVisitDate;

    private String visitor;

    @Column(length = 1000)
    private String remark;

    public MaintenanceVisit() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public String getVisitType() { return visitType; }
    public void setVisitType(String visitType) { this.visitType = visitType; }
    public String getVisitorName() { return visitorName; }
    public void setVisitorName(String visitorName) { this.visitorName = visitorName; }
    public String getVisitorPhone() { return visitorPhone; }
    public void setVisitorPhone(String visitorPhone) { this.visitorPhone = visitorPhone; }
    public String getVisitResult() { return visitResult; }
    public void setVisitResult(String visitResult) { this.visitResult = visitResult; }
    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
    public LocalDate getVisitDate() { return visitDate; }
    public void setVisitDate(LocalDate visitDate) { this.visitDate = visitDate; }
    public LocalDate getNextVisitDate() { return nextVisitDate; }
    public void setNextVisitDate(LocalDate nextVisitDate) { this.nextVisitDate = nextVisitDate; }
    public String getVisitor() { return visitor; }
    public void setVisitor(String visitor) { this.visitor = visitor; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}
