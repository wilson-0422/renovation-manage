package com.renovation.manage.controller;

import com.renovation.manage.model.ConstructionNode;
import com.renovation.manage.service.ConstructionService;
import com.renovation.manage.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/construction")
public class ConstructionController {

    private final ConstructionService constructionService;
    private final ProjectService projectService;

    public ConstructionController(ConstructionService constructionService, ProjectService projectService) {
        this.constructionService = constructionService;
        this.projectService = projectService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("nodes", constructionService.findAll());
        return "construction/list";
    }

    @GetMapping("/create")
    public String createForm(@RequestParam(required = false) Long projectId, Model model) {
        ConstructionNode node = new ConstructionNode();
        if (projectId != null) {
            node.setProjectId(projectId);
        }
        model.addAttribute("node", node);
        model.addAttribute("projects", projectService.findAll());
        return "construction/create";
    }

    @PostMapping
    public String create(@ModelAttribute ConstructionNode node) {
        constructionService.save(node);
        return "redirect:/construction";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        ConstructionNode node = constructionService.findById(id);
        model.addAttribute("node", node);
        model.addAttribute("project", projectService.findById(node.getProjectId()));
        return "construction/detail";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute ConstructionNode node) {
        constructionService.update(id, node);
        return "redirect:/construction/" + id;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        constructionService.deleteById(id);
        return "redirect:/construction";
    }
}
