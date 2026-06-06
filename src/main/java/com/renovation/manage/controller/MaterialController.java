package com.renovation.manage.controller;

import com.renovation.manage.model.MaterialAcceptance;
import com.renovation.manage.service.MaterialService;
import com.renovation.manage.service.ProjectService;
import com.renovation.manage.service.ConstructionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/materials")
public class MaterialController {

    private final MaterialService materialService;
    private final ProjectService projectService;
    private final ConstructionService constructionService;

    public MaterialController(MaterialService materialService, ProjectService projectService, ConstructionService constructionService) {
        this.materialService = materialService;
        this.projectService = projectService;
        this.constructionService = constructionService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("materials", materialService.findAll());
        return "materials/list";
    }

    @GetMapping("/create")
    public String createForm(@RequestParam(required = false) Long projectId,
                             @RequestParam(required = false) Long nodeId, Model model) {
        MaterialAcceptance material = new MaterialAcceptance();
        if (projectId != null) {
            material.setProjectId(projectId);
        }
        if (nodeId != null) {
            material.setNodeId(nodeId);
        }
        model.addAttribute("material", material);
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("nodes", constructionService.findAll());
        return "materials/create";
    }

    @PostMapping
    public String create(@ModelAttribute MaterialAcceptance material) {
        materialService.save(material);
        return "redirect:/materials";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        MaterialAcceptance material = materialService.findById(id);
        model.addAttribute("material", material);
        model.addAttribute("project", projectService.findById(material.getProjectId()));
        return "materials/detail";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        materialService.deleteById(id);
        return "redirect:/materials";
    }
}
