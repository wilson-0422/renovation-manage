package com.renovation.manage.controller;

import com.renovation.manage.model.MaintenanceVisit;
import com.renovation.manage.service.MaintenanceService;
import com.renovation.manage.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;
    private final ProjectService projectService;

    public MaintenanceController(MaintenanceService maintenanceService, ProjectService projectService) {
        this.maintenanceService = maintenanceService;
        this.projectService = projectService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("visits", maintenanceService.findAll());
        return "maintenance/list";
    }

    @GetMapping("/create")
    public String createForm(@RequestParam(required = false) Long projectId, Model model) {
        MaintenanceVisit visit = new MaintenanceVisit();
        if (projectId != null) {
            visit.setProjectId(projectId);
        }
        model.addAttribute("visit", visit);
        model.addAttribute("projects", projectService.findAll());
        return "maintenance/create";
    }

    @PostMapping
    public String create(@ModelAttribute MaintenanceVisit visit) {
        maintenanceService.save(visit);
        return "redirect:/maintenance";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        MaintenanceVisit visit = maintenanceService.findById(id);
        model.addAttribute("visit", visit);
        model.addAttribute("project", projectService.findById(visit.getProjectId()));
        return "maintenance/detail";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        maintenanceService.deleteById(id);
        return "redirect:/maintenance";
    }
}
