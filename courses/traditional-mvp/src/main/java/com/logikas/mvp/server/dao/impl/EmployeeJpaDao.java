package com.logikas.mvp.server.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.logikas.mvp.server.dao.EmployeeDao;
import com.logikas.mvp.server.domain.Employee;

public class EmployeeJpaDao implements EmployeeDao {

    private Provider<EntityManager> em;

    @Inject
    public EmployeeJpaDao(Provider<EntityManager> em) {
        this.em = em;
    }

    @Override
    public void persist(Employee entity) {
        em.get().getTransaction().begin();
        this.em.get().persist(entity);
        em.get().getTransaction().commit();
    }

    @Override
    public void remove(Employee entity) {
        // TODO Auto-generated method stub
    }

    @Override
    public Employee findById(Long id) {
        return this.em.get().find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        return em.get().createNamedQuery("Employee.findAll").getResultList();
    }
}
