package com.renovation.manage.repository;

import com.renovation.manage.model.MaintenanceVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaintenanceVisitRepository extends JpaRepository<MaintenanceVisit, Long> {
    List<MaintenanceVisit> findByProjectId(Long projectId);
    List<MaintenanceVisit> findByProjectIdAndVisitType(Long projectId, String visitType);
}
