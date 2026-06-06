package com.renovation.manage.service;

import com.renovation.manage.model.MaterialAcceptance;
import com.renovation.manage.repository.MaterialAcceptanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    private final MaterialAcceptanceRepository materialRepository;

    public MaterialService(MaterialAcceptanceRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<MaterialAcceptance> findAll() {
        return materialRepository.findAll();
    }

    public MaterialAcceptance findById(Long id) {
        return materialRepository.findById(id).orElseThrow(() -> new RuntimeException("材料验收记录未找到"));
    }

    public MaterialAcceptance save(MaterialAcceptance material) {
        return materialRepository.save(material);
    }

    public void deleteById(Long id) {
        materialRepository.deleteById(id);
    }

    public List<MaterialAcceptance> findByProjectId(Long projectId) {
        return materialRepository.findByProjectId(projectId);
    }

    public List<MaterialAcceptance> findByNodeId(Long nodeId) {
        return materialRepository.findByNodeId(nodeId);
    }
}
