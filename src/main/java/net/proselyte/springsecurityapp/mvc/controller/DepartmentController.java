package net.proselyte.springsecurityapp.mvc.controller;

import net.proselyte.springsecurityapp.mvc.model.Department;
import net.proselyte.springsecurityapp.mvc.model.Employee;
import net.proselyte.springsecurityapp.mvc.service.DepartmentService;
import net.proselyte.springsecurityapp.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 38066 on 24.01.2019.
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;

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
        return "user-home";
    }

    @GetMapping("/getAllDepartmentsForSimpleUser")
    public ModelAndView getAllDepartments() {
        ModelAndView modelAndView = new ModelAndView("getAllDepartments");
        modelAndView.addObject("deps", departmentService.getAll());
        return modelAndView;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome-page";
    }

    @GetMapping("/userAccess")
    public String userAccess() {
        return "user/user-home";
    }

    @GetMapping("/moderatorAccess")
    public String moderatorAccess() {
        return "moderator/moderator-home";
    }

    @GetMapping("/adminAccess")
    public String adminAccess() {
        return "admin/admin-home";
    }



    /**================================================================
     * Employees Controllers
     * ================================================================
     * */



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
        return "user-home";
    }

    @GetMapping("/getAllEmployeesForSimpleUser")
    public ModelAndView getAllEmployees() {
        ModelAndView modelAndView = new ModelAndView("getAllEmployees");
        modelAndView.addObject("empl", employeeService.getAll());
        return modelAndView;
    }
}
