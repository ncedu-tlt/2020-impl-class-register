package com.pozhenskii.spring.mvc_hibernate_aop.service;

import com.pozhenskii.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.pozhenskii.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService { //будет подключаться к бд с помощью hiber

    @Autowired //di в действии
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional // чтобы не открывать и закрывать транзакцию сомастоятельно
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
