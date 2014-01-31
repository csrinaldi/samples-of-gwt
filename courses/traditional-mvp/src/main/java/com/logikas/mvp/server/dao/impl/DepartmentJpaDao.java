package com.logikas.mvp.server.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.logikas.mvp.server.dao.DepartmentDao;
import com.logikas.mvp.server.domain.Department;

public class DepartmentJpaDao implements DepartmentDao {

    private Provider<EntityManager> em;

    @Inject
    public DepartmentJpaDao(Provider<EntityManager> em) {
        this.em = em;
    }

    @Override
    public void persist(Department entity) {
        em.get().getTransaction().begin();
        this.em.get().persist(entity);
        em.get().getTransaction().commit();
    }

    @Override
    public void remove(Department entity) {
        // TODO Auto-generated method stub
    }

    @Override
    public Department findById(Long id) {
        return this.em.get().find(Department.class, id);
    }

    @Override
    public List<Department> findAll() {
        return em.get().createNamedQuery("Department.findAll").getResultList();
    }
}
