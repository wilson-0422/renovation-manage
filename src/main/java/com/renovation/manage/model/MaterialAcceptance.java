package com.renovation.manage.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "material_acceptances")
public class MaterialAcceptance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long projectId;

    @Column(nullable = false)
    private Long nodeId;

    @Column(nullable = false)
    private String materialName;

    @Column(nullable = false)
    private String specification;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    @Column(nullable = false)
    private String acceptanceResult;

    private LocalDate acceptanceDate;

    private String inspector;

    @Column(length = 1000)
    private String remark;

    public MaterialAcceptance() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public Long getNodeId() { return nodeId; }
    public void setNodeId(Long nodeId) { this.nodeId = nodeId; }
    public String getMaterialName() { return materialName; }
    public void setMaterialName(String materialName) { this.materialName = materialName; }
    public String getSpecification() { return specification; }
    public void setSpecification(String specification) { this.specification = specification; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
    public String getAcceptanceResult() { return acceptanceResult; }
    public void setAcceptanceResult(String acceptanceResult) { this.acceptanceResult = acceptanceResult; }
    public LocalDate getAcceptanceDate() { return acceptanceDate; }
    public void setAcceptanceDate(LocalDate acceptanceDate) { this.acceptanceDate = acceptanceDate; }
    public String getInspector() { return inspector; }
    public void setInspector(String inspector) { this.inspector = inspector; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}
