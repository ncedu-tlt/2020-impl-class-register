package com.pozhenskii.spring.mvc_hibernate_aop.dao;

import com.pozhenskii.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO { //будет подключаться к бд с помощью hiber
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session
                //notAnError.exe :)  этот form не ошибка!!!, но пытается ей быть!
                .createQuery("from Employee", Employee.class) //получаем всех
                .getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        //добавляем или добавляем в базу в базу
        // выбераем действие по id, если >1, то up, если 0, то sa
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id); //достаём из базы по id
        return employee;
    }
}
