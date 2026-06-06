package com.renovation.manage.service;

import com.renovation.manage.model.RenovationProject;
import com.renovation.manage.repository.RenovationProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final RenovationProjectRepository projectRepository;

    public ProjectService(RenovationProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<RenovationProject> findAll() {
        return projectRepository.findAll();
    }

    public RenovationProject findById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("项目未找到"));
    }

    public RenovationProject save(RenovationProject project) {
        return projectRepository.save(project);
    }

    public RenovationProject update(Long id, RenovationProject project) {
        RenovationProject existing = findById(id);
        existing.setName(project.getName());
        existing.setAddress(project.getAddress());
        existing.setBudget(project.getBudget());
        existing.setStatus(project.getStatus());
        existing.setStartDate(project.getStartDate());
        existing.setEndDate(project.getEndDate());
        existing.setDescription(project.getDescription());
        existing.setTotalHouseholds(project.getTotalHouseholds());
        existing.setResponsiblePerson(project.getResponsiblePerson());
        existing.setContactPhone(project.getContactPhone());
        return projectRepository.save(existing);
    }

    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }

    public List<RenovationProject> findByStatus(String status) {
        return projectRepository.findByStatus(status);
    }

    public long countByStatus(String status) {
        return projectRepository.countByStatus(status);
    }

    public long count() {
        return projectRepository.count();
    }
}
