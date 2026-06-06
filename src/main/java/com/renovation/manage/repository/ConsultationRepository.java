package com.renovation.manage.repository;

import com.renovation.manage.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByProjectId(Long projectId);
    List<Consultation> findByProjectIdAndStatus(Long projectId, String status);
    long countByProjectId(Long projectId);
    long countByProjectIdAndOpinion(Long projectId, String opinion);
}
