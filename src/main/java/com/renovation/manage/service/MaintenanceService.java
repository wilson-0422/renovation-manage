package com.renovation.manage.service;

import com.renovation.manage.model.MaintenanceVisit;
import com.renovation.manage.repository.MaintenanceVisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {

    private final MaintenanceVisitRepository maintenanceVisitRepository;

    public MaintenanceService(MaintenanceVisitRepository maintenanceVisitRepository) {
        this.maintenanceVisitRepository = maintenanceVisitRepository;
    }

    public List<MaintenanceVisit> findAll() {
        return maintenanceVisitRepository.findAll();
    }

    public MaintenanceVisit findById(Long id) {
        return maintenanceVisitRepository.findById(id).orElseThrow(() -> new RuntimeException("维保回访记录未找到"));
    }

    public MaintenanceVisit save(MaintenanceVisit visit) {
        return maintenanceVisitRepository.save(visit);
    }

    public void deleteById(Long id) {
        maintenanceVisitRepository.deleteById(id);
    }

    public List<MaintenanceVisit> findByProjectId(Long projectId) {
        return maintenanceVisitRepository.findByProjectId(projectId);
    }
}
