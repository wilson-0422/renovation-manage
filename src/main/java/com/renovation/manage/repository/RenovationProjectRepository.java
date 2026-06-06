package com.renovation.manage.repository;

import com.renovation.manage.model.RenovationProject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RenovationProjectRepository extends JpaRepository<RenovationProject, Long> {
    List<RenovationProject> findByStatus(String status);
    long countByStatus(String status);
}
