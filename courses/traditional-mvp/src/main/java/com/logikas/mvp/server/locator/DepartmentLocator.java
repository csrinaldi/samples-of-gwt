/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.mvp.server.locator;

import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.logikas.mvp.server.dao.DepartmentDao;
import com.logikas.mvp.server.domain.Department;

/**
 *
 * @author scit232
 */
public class DepartmentLocator extends Locator<Department, Long> {

    private final DepartmentDao dao;

    @Inject
    DepartmentLocator(DepartmentDao dao) {
        this.dao = dao;
    }

    @Override
    public Department create(Class<? extends Department> clazz) {
        return new Department();
    }

    @Override
    public Department find(Class<? extends Department> clazz, Long id) {
        return dao.findById(id);
    }

    @Override
    public Class<Department> getDomainType() {
        return Department.class;
    }

    @Override
    public Long getId(Department department) {
        return department.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(Department department) {
        return department.getVersion();
    }
}
