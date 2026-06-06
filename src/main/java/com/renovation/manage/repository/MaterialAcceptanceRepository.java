package com.renovation.manage.repository;

import com.renovation.manage.model.MaterialAcceptance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaterialAcceptanceRepository extends JpaRepository<MaterialAcceptance, Long> {
    List<MaterialAcceptance> findByProjectId(Long projectId);
    List<MaterialAcceptance> findByNodeId(Long nodeId);
    List<MaterialAcceptance> findByProjectIdAndAcceptanceResult(Long projectId, String acceptanceResult);
}
