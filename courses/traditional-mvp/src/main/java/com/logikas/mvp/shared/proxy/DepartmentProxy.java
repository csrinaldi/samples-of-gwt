package com.logikas.mvp.shared.proxy;


import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.logikas.mvp.server.domain.Department;
import com.logikas.mvp.server.locator.DepartmentLocator;

@ProxyFor(value = Department.class, locator = DepartmentLocator.class)
public interface DepartmentProxy extends EntityProxy {

    @Override
    EntityProxyId<DepartmentProxy> stableId();

    String getName();

    void setName(String name);
}
