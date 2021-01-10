package com.pozhenskii.spring.springboot.springboot_rest.service;

import com.pozhenskii.spring.springboot.springboot_rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
