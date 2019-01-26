package net.proselyte.springsecurityapp.mvc.controller;

import net.proselyte.springsecurityapp.mvc.model.Department;
import net.proselyte.springsecurityapp.mvc.model.Employee;
import net.proselyte.springsecurityapp.mvc.model.ID;
import net.proselyte.springsecurityapp.mvc.repository.DepartmentRepository;
import net.proselyte.springsecurityapp.mvc.repository.EmployeeRepository;
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

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * ================================================================
     * Departments Controllers
     * ================================================================
     */

    @GetMapping("/updateDepartment")
    public String updateDepartment(Model model) {
        model.addAttribute("updateDepartment", new Department());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("departments", departmentService.getAll());
        return "update-department";
    }

    @PostMapping("/updateDepartment")
    public String updateDepartment(@ModelAttribute("updateDepartment") Department department,
                                   @RequestParam(value = "cers", required = false)
                                           int[] cers) {
        if (cers != null) {
            Employee employee = null;
            for (int i = 0; i < cers.length; i++) {
                if (employeeRepository.existsById(cers[i])) {
                    employee = new Employee();
                    employee.setId(cers[i]);
                    department.getEmployees().add(employee);
                }
            }
            departmentService.update(department);
            return "successfully";
        }
        return "update-department";
    }

    @GetMapping("/saveDepartment")
    public String saveDepartment(Model model) {
        model.addAttribute("saveDepartment", new Department());
        model.addAttribute("employees", employeeService.getAll());
        return "save-department";
    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("saveDepartment") Department department,
                                 @RequestParam(value = "cers", required = false)
                                         int[] cers) {
        if (cers != null) {
            Employee employee = null;
            for (int i = 0; i < cers.length; i++) {
                if (employeeRepository.existsById(cers[i])) {
                    employee = new Employee();
                    employee.setId(cers[i]);
                    department.getEmployees().add(employee);
                }
            }
            departmentService.save(department);
            return "successfully";
        }
        return "save-department";
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
        return "successfully";
    }

    /**
     * ================================================================
     * Employees Controllers
     * ================================================================
     */


    @GetMapping("/updateEmployee")
    public String updateEmployee(Model model) {
        model.addAttribute("updateEmployee", new Employee());
        model.addAttribute("employees", employeeService.getAll());
        return "update-employee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("updateEmployee") Employee employee) {
        if (employee != null) {
            employeeService.update(employee);
            return "successfully";
        }
        return "save-employee";
    }


    @GetMapping("/saveEmployee")
    public String saveEmployee(Model model) {
        model.addAttribute("saveEmployee", new Employee());
        return "save-employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("saveEmployee") Employee employee) {
        if (employee != null) {
            employeeService.save(employee);
            return "successfully";
        }
        return "save-employee";
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

    @GetMapping("/deleteEmplById")
    public String deleteEmplById(Model model) {
        model.addAttribute("deleter", new ID());
        return "emplDeleter";
    }

    @PostMapping("/deleteEmplById")
    public String deleteEmplById(@Valid @ModelAttribute("deleter") ID id) {
        employeeService.delete(Integer.parseInt(id.getId()));
        if (employeeRepository.existsById(Integer.parseInt(id.getId()))) {
            return "emplDeleter";
        }
        return "successfully";
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

    @GetMapping("/goToDepartments")
    public String goToDepartments() {
        return "goToDepartments";
    }

    @GetMapping("/goToEmployees")
    public String goToEmployees() {
        return "goToEmployees";
    }
}
