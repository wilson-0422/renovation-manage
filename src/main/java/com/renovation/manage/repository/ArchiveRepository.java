package com.renovation.manage.repository;

import com.renovation.manage.model.Archive;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArchiveRepository extends JpaRepository<Archive, Long> {
    List<Archive> findByProjectId(Long projectId);
    List<Archive> findByProjectIdAndArchiveType(Long projectId, String archiveType);
}
