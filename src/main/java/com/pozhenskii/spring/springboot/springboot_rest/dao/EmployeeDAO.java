package com.pozhenskii.spring.springboot.springboot_rest.dao;

import com.pozhenskii.spring.springboot.springboot_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
