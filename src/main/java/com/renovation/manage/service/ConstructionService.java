package com.renovation.manage.service;

import com.renovation.manage.model.ConstructionNode;
import com.renovation.manage.repository.ConstructionNodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstructionService {

    private final ConstructionNodeRepository constructionNodeRepository;

    public ConstructionService(ConstructionNodeRepository constructionNodeRepository) {
        this.constructionNodeRepository = constructionNodeRepository;
    }

    public List<ConstructionNode> findAll() {
        return constructionNodeRepository.findAll();
    }

    public ConstructionNode findById(Long id) {
        return constructionNodeRepository.findById(id).orElseThrow(() -> new RuntimeException("施工节点未找到"));
    }

    public ConstructionNode save(ConstructionNode node) {
        return constructionNodeRepository.save(node);
    }

    public ConstructionNode update(Long id, ConstructionNode node) {
        ConstructionNode existing = findById(id);
        existing.setNodeName(node.getNodeName());
        existing.setNodeType(node.getNodeType());
        existing.setStatus(node.getStatus());
        existing.setPlannedStart(node.getPlannedStart());
        existing.setPlannedEnd(node.getPlannedEnd());
        existing.setActualStart(node.getActualStart());
        existing.setActualEnd(node.getActualEnd());
        existing.setDescription(node.getDescription());
        existing.setSupervisor(node.getSupervisor());
        return constructionNodeRepository.save(existing);
    }

    public void deleteById(Long id) {
        constructionNodeRepository.deleteById(id);
    }

    public List<ConstructionNode> findByProjectId(Long projectId) {
        return constructionNodeRepository.findByProjectId(projectId);
    }
}
