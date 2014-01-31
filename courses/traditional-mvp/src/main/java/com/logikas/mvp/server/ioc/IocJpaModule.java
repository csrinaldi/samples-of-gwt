/**
 *
 */
package com.logikas.mvp.server.ioc;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;
import com.logikas.mvp.server.dao.DepartmentDao;
import com.logikas.mvp.server.dao.EmployeeDao;
import com.logikas.mvp.server.dao.impl.DepartmentJpaDao;
import com.logikas.mvp.server.dao.impl.EmployeeJpaDao;

/**
 * Package: com.logikas.erp.server.ioc File: ErpJpaModule.java Date: 27/09/2011
 *
 * @autor cristian - Logikas Conectando Ideas
 */
public class IocJpaModule extends AbstractModule {

    /**
     * Configuration of Dao implementations
     *
     * @see com.google.inject.AbstractModule#configure()
     */
    @Override
    protected void configure() {
        bind(EmployeeDao.class).to(EmployeeJpaDao.class).in(Singleton.class);
        bind(DepartmentDao.class).to(DepartmentJpaDao.class).in(Singleton.class);
    }
    
}
