package com.renovation.manage.dto;

public class DashboardStats {

    private long totalProjects;
    private long ongoingProjects;
    private long completedProjects;
    private long totalConsultations;
    private long totalConstructionNodes;
    private long totalMaterials;
    private long totalArchives;
    private long totalMaintenanceVisits;

    public DashboardStats() {}

    public long getTotalProjects() { return totalProjects; }
    public void setTotalProjects(long totalProjects) { this.totalProjects = totalProjects; }
    public long getOngoingProjects() { return ongoingProjects; }
    public void setOngoingProjects(long ongoingProjects) { this.ongoingProjects = ongoingProjects; }
    public long getCompletedProjects() { return completedProjects; }
    public void setCompletedProjects(long completedProjects) { this.completedProjects = completedProjects; }
    public long getTotalConsultations() { return totalConsultations; }
    public void setTotalConsultations(long totalConsultations) { this.totalConsultations = totalConsultations; }
    public long getTotalConstructionNodes() { return totalConstructionNodes; }
    public void setTotalConstructionNodes(long totalConstructionNodes) { this.totalConstructionNodes = totalConstructionNodes; }
    public long getTotalMaterials() { return totalMaterials; }
    public void setTotalMaterials(long totalMaterials) { this.totalMaterials = totalMaterials; }
    public long getTotalArchives() { return totalArchives; }
    public void setTotalArchives(long totalArchives) { this.totalArchives = totalArchives; }
    public long getTotalMaintenanceVisits() { return totalMaintenanceVisits; }
    public void setTotalMaintenanceVisits(long totalMaintenanceVisits) { this.totalMaintenanceVisits = totalMaintenanceVisits; }
}
