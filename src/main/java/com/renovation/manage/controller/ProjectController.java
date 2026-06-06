package com.renovation.manage.controller;

import com.renovation.manage.model.RenovationProject;
import com.renovation.manage.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "projects/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.findById(id));
        return "projects/detail";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("project", new RenovationProject());
        return "projects/create";
    }

    @PostMapping
    public String create(@ModelAttribute RenovationProject project) {
        projectService.save(project);
        return "redirect:/projects";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.findById(id));
        return "projects/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute RenovationProject project) {
        projectService.update(id, project);
        return "redirect:/projects/" + id;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        projectService.deleteById(id);
        return "redirect:/projects";
    }
}
