package net.proselyte.springsecurityapp.mvc.controller;

import net.proselyte.springsecurityapp.mvc.model.Employee;
import net.proselyte.springsecurityapp.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by 38066 on 24.01.2019.
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/saveEmployee")
    public String saveEmployee(Model model) {
        model.addAttribute("saveEmployee", new Employee());
        return "save-employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("saveEmployee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "save-employee";
        }
        employeeService.save(employee);
        return "user/user-home";
    }
}