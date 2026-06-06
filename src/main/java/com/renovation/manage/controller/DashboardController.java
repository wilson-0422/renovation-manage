package com.renovation.manage.controller;

import com.renovation.manage.dto.DashboardStats;
import com.renovation.manage.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final ProjectService projectService;
    private final ConsultationService consultationService;
    private final ConstructionService constructionService;
    private final MaterialService materialService;
    private final ArchiveService archiveService;
    private final MaintenanceService maintenanceService;

    public DashboardController(ProjectService projectService,
                               ConsultationService consultationService,
                               ConstructionService constructionService,
                               MaterialService materialService,
                               ArchiveService archiveService,
                               MaintenanceService maintenanceService) {
        this.projectService = projectService;
        this.consultationService = consultationService;
        this.constructionService = constructionService;
        this.materialService = materialService;
        this.archiveService = archiveService;
        this.maintenanceService = maintenanceService;
    }

    @GetMapping
    public String overview(Model model) {
        DashboardStats stats = new DashboardStats();
        stats.setTotalProjects(projectService.count());
        stats.setOngoingProjects(projectService.countByStatus("进行中"));
        stats.setCompletedProjects(projectService.countByStatus("已完成"));
        stats.setTotalConsultations(consultationService.findAll().size());
        stats.setTotalConstructionNodes(constructionService.findAll().size());
        stats.setTotalMaterials(materialService.findAll().size());
        stats.setTotalArchives(archiveService.findAll().size());
        stats.setTotalMaintenanceVisits(maintenanceService.findAll().size());

        model.addAttribute("stats", stats);
        model.addAttribute("projects", projectService.findAll());
        return "dashboard/overview";
    }
}
