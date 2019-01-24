package net.proselyte.springsecurityapp.mvc.controller;

import net.proselyte.springsecurityapp.mvc.model.Department;
import net.proselyte.springsecurityapp.mvc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by 38066 on 24.01.2019.
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/saveDepartment")
    public String saveDepartment(Model model) {
        model.addAttribute("saveDepartment", new Department());
        return "save-department";
    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("saveDepartment") Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "save-department";
        }
        departmentService.save(department);
        return "user/user-home";
    }

    @GetMapping("/getAllDepartments")
    public ModelAndView getAllDepartments() {
        ModelAndView modelAndView = new ModelAndView("user/getAllDepartments");
        modelAndView.addObject("deps", departmentService.getAll());
        return modelAndView;
    }
}
