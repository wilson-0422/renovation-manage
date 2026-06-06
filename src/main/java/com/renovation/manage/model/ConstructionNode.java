package com.renovation.manage.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "construction_nodes")
public class ConstructionNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long projectId;

    @Column(nullable = false)
    private String nodeName;

    @Column(nullable = false)
    private String nodeType;

    @Column(nullable = false)
    private String status;

    private LocalDate plannedStart;
    private LocalDate plannedEnd;
    private LocalDate actualStart;
    private LocalDate actualEnd;

    @Column(length = 1000)
    private String description;

    private String supervisor;

    public ConstructionNode() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public String getNodeName() { return nodeName; }
    public void setNodeName(String nodeName) { this.nodeName = nodeName; }
    public String getNodeType() { return nodeType; }
    public void setNodeType(String nodeType) { this.nodeType = nodeType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getPlannedStart() { return plannedStart; }
    public void setPlannedStart(LocalDate plannedStart) { this.plannedStart = plannedStart; }
    public LocalDate getPlannedEnd() { return plannedEnd; }
    public void setPlannedEnd(LocalDate plannedEnd) { this.plannedEnd = plannedEnd; }
    public LocalDate getActualStart() { return actualStart; }
    public void setActualStart(LocalDate actualStart) { this.actualStart = actualStart; }
    public LocalDate getActualEnd() { return actualEnd; }
    public void setActualEnd(LocalDate actualEnd) { this.actualEnd = actualEnd; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSupervisor() { return supervisor; }
    public void setSupervisor(String supervisor) { this.supervisor = supervisor; }
}
