package com.renovation.manage.controller;

import com.renovation.manage.model.Consultation;
import com.renovation.manage.model.RenovationProject;
import com.renovation.manage.service.ConsultationService;
import com.renovation.manage.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultations")
public class ConsultationController {

    private final ConsultationService consultationService;
    private final ProjectService projectService;

    public ConsultationController(ConsultationService consultationService, ProjectService projectService) {
        this.consultationService = consultationService;
        this.projectService = projectService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("consultations", consultationService.findAll());
        return "consultations/list";
    }

    @GetMapping("/create")
    public String createForm(@RequestParam(required = false) Long projectId, Model model) {
        Consultation consultation = new Consultation();
        if (projectId != null) {
            consultation.setProjectId(projectId);
        }
        model.addAttribute("consultation", consultation);
        model.addAttribute("projects", projectService.findAll());
        return "consultations/create";
    }

    @PostMapping
    public String create(@ModelAttribute Consultation consultation) {
        consultationService.save(consultation);
        return "redirect:/consultations";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Consultation consultation = consultationService.findById(id);
        model.addAttribute("consultation", consultation);
        model.addAttribute("project", projectService.findById(consultation.getProjectId()));
        return "consultations/detail";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        consultationService.deleteById(id);
        return "redirect:/consultations";
    }
}
