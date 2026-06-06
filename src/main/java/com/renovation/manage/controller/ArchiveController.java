package com.renovation.manage.controller;

import com.renovation.manage.model.Archive;
import com.renovation.manage.service.ArchiveService;
import com.renovation.manage.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/archives")
public class ArchiveController {

    private final ArchiveService archiveService;
    private final ProjectService projectService;

    public ArchiveController(ArchiveService archiveService, ProjectService projectService) {
        this.archiveService = archiveService;
        this.projectService = projectService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("archives", archiveService.findAll());
        return "archives/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Archive archive = archiveService.findById(id);
        model.addAttribute("archive", archive);
        model.addAttribute("project", projectService.findById(archive.getProjectId()));
        return "archives/detail";
    }

    @PostMapping
    public String create(@ModelAttribute Archive archive) {
        archiveService.save(archive);
        return "redirect:/archives";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        archiveService.deleteById(id);
        return "redirect:/archives";
    }
}
