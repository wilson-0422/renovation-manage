package com.renovation.manage.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "renovation_projects")
public class RenovationProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private BigDecimal budget;

    @Column(nullable = false)
    private String status;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(length = 2000)
    private String description;

    private Integer totalHouseholds;

    private String responsiblePerson;

    private String contactPhone;

    public RenovationProject() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public BigDecimal getBudget() { return budget; }
    public void setBudget(BigDecimal budget) { this.budget = budget; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getTotalHouseholds() { return totalHouseholds; }
    public void setTotalHouseholds(Integer totalHouseholds) { this.totalHouseholds = totalHouseholds; }
    public String getResponsiblePerson() { return responsiblePerson; }
    public void setResponsiblePerson(String responsiblePerson) { this.responsiblePerson = responsiblePerson; }
    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }
}
