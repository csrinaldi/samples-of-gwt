package com.logikas.mvp.server.locator;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.logikas.mvp.server.dao.EmployeeDao;
import com.logikas.mvp.server.domain.Employee;

@Singleton
public class EmployeeLocator extends Locator<Employee, Long> {

    private final EmployeeDao dao;

    @Inject
    EmployeeLocator(EmployeeDao dao) {
        this.dao = dao;
    }

    @Override
    public Employee create(Class<? extends Employee> clazz) {
        return new Employee();
    }

    @Override
    public Employee find(Class<? extends Employee> clazz, Long id) {
        return dao.findById(id);
    }

    @Override
    public Class<Employee> getDomainType() {
        return Employee.class;
    }

    @Override
    public Long getId(Employee employee) {
        return employee.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(Employee employee) {
        return employee.getVersion();
    }
}
