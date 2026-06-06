package com.renovation.manage.repository;

import com.renovation.manage.model.ConstructionNode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConstructionNodeRepository extends JpaRepository<ConstructionNode, Long> {
    List<ConstructionNode> findByProjectId(Long projectId);
    List<ConstructionNode> findByProjectIdAndStatus(Long projectId, String status);
}
