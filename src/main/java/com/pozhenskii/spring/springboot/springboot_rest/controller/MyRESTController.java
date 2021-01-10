package com.pozhenskii.spring.springboot.springboot_rest.controller;

import com.pozhenskii.spring.springboot.springboot_rest.entity.Employee;
import com.pozhenskii.spring.springboot.springboot_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //уже не Controller
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees") //множественное число по стандарту
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees; // на данном моменте Spring включает jackson,
        // который конвертит java objects в json
        // и нам больше ничего не нужно делать!
    }

    @GetMapping("/employees/{id}") //вместо Id мы можем поставить что угодно
    public Employee getEmployee(@PathVariable int id) { //получаем занчение из URL
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @PostMapping("/employees") //множественное число по стандарту
    public Employee addNewEmployees(@RequestBody Employee employee) {  //Достаём работника из body
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees") //множественное число по стандарту
    public Employee updateEmployees(@RequestBody Employee employee) {  //Достаём работника из body
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}") //вместо Id мы можем поставить что угодно
    public String deleteEmployee(@PathVariable int id) { //получаем занчение из URL
        Employee employee = employeeService.getEmployee(id);

        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted!";
    }
}
