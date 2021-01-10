package com.pozhenskii.spring.springboot.springboot_rest.dao;

import com.pozhenskii.spring.springboot.springboot_rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO { //будет подключаться к бд с помощью hiber
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);
        List<Employee> allEmployees = session
                //notAnError.exe :)  этот form не ошибка!!!, но пытается ей быть!
                .createQuery("from Employee", Employee.class) //получаем всех
                .getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);

        //добавляем или добавляем в базу в базу
        // выбераем действие по id, если >1, то up, если 0, то sa
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id); //достаём из базы по id
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("delete from Employee " +
                "where id =:employeeId"); //вместо employeeId мы пропишем парамметр!
        query.setParameter("employeeId", id);

        query.executeUpdate(); //как и delete, так и update!
    }
}
