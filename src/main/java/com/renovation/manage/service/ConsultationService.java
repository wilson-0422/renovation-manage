package com.renovation.manage.service;

import com.renovation.manage.model.Consultation;
import com.renovation.manage.repository.ConsultationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    private final ConsultationRepository consultationRepository;

    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

    public Consultation findById(Long id) {
        return consultationRepository.findById(id).orElseThrow(() -> new RuntimeException("征询记录未找到"));
    }

    public Consultation save(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public void deleteById(Long id) {
        consultationRepository.deleteById(id);
    }

    public List<Consultation> findByProjectId(Long projectId) {
        return consultationRepository.findByProjectId(projectId);
    }

    public long countByProjectId(Long projectId) {
        return consultationRepository.countByProjectId(projectId);
    }

    public long countAgreeByProjectId(Long projectId) {
        return consultationRepository.countByProjectIdAndOpinion(projectId, "同意");
    }
}
