package com.renovation.manage.service;

import com.renovation.manage.model.Archive;
import com.renovation.manage.repository.ArchiveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveService {

    private final ArchiveRepository archiveRepository;

    public ArchiveService(ArchiveRepository archiveRepository) {
        this.archiveRepository = archiveRepository;
    }

    public List<Archive> findAll() {
        return archiveRepository.findAll();
    }

    public Archive findById(Long id) {
        return archiveRepository.findById(id).orElseThrow(() -> new RuntimeException("档案未找到"));
    }

    public Archive save(Archive archive) {
        return archiveRepository.save(archive);
    }

    public void deleteById(Long id) {
        archiveRepository.deleteById(id);
    }

    public List<Archive> findByProjectId(Long projectId) {
        return archiveRepository.findByProjectId(projectId);
    }

    public List<Archive> findByProjectIdAndArchiveType(Long projectId, String archiveType) {
        return archiveRepository.findByProjectIdAndArchiveType(projectId, archiveType);
    }
}
