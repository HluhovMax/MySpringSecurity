package net.proselyte.springsecurityapp.mvc.controller;

import net.proselyte.springsecurityapp.mvc.model.Department;
import net.proselyte.springsecurityapp.mvc.model.Employee;
import net.proselyte.springsecurityapp.mvc.model.ID;
import net.proselyte.springsecurityapp.mvc.repository.DepartmentRepository;
import net.proselyte.springsecurityapp.mvc.service.DepartmentService;
import net.proselyte.springsecurityapp.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 38066 on 24.01.2019.
 */
@Controller
public class MyController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepository departmentRepository;

    /**================================================================
     * Departments Controllers
     * ================================================================
     * */

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

    @GetMapping("/getAllDepartments")
    public ModelAndView getAllDepartments() {
        ModelAndView modelAndView = new ModelAndView("getAllDepartments");
        modelAndView.addObject("deps", departmentService.getAll());
        return modelAndView;
    }

    @GetMapping("/getDeptById")
    public String getDeptById(Model model) {
        model.addAttribute("identifier", new ID());
        return "deptIdentifier";
    }

    @RequestMapping(value = "/getDeptById", method = RequestMethod.POST)
    public ModelAndView getDeptById(@Valid @ModelAttribute("identifier") ID id) {
        List<Department> departments = new ArrayList<>();
        departments.add(departmentService.getById(Integer.parseInt(id.getId())));
        ModelAndView modelAndView = new ModelAndView("getDeptById");
        modelAndView.addObject("dep", departments);
        return modelAndView;
    }

    @GetMapping("/deleteDeptById")
    public String deleteDeptById(Model model) {
        model.addAttribute("deleter", new ID());
        return "deptDeleter";
    }

    @PostMapping("/deleteDeptById")
    public String deleteDeptById(@Valid @ModelAttribute("deleter") ID id) {
        departmentService.delete(Integer.parseInt(id.getId()));
        if (departmentRepository.existsById(Integer.parseInt(id.getId()))) {
            return "deptDeleter";
        }
        return "successfullyDeleted";
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

    @GetMapping("/getAllEmployees")
    public ModelAndView getAllEmployees() {
        ModelAndView modelAndView = new ModelAndView("getAllEmployees");
        modelAndView.addObject("empl", employeeService.getAll());
        return modelAndView;
    }

    @GetMapping("/getEmplById")
    public String getEmplById(Model model) {
        model.addAttribute("identifier", new ID());
        return "emplIdentifier";
    }

    @PostMapping("/getEmplById")
    public ModelAndView getEmplById(@Valid @ModelAttribute("identifier") ID id) {
        List<Employee> employees = new ArrayList<>();
        employees.add(employeeService.getById(Integer.parseInt(id.getId())));
        ModelAndView modelAndView = new ModelAndView("getEmplById");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    /**
     * ACCESSING CONTROLLERS
     * */

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
}
