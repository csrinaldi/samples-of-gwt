package com.logikas.mvp.shared.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.logikas.mvp.server.domain.Employee;
import com.logikas.mvp.server.locator.EmployeeLocator;

@ProxyFor(value = Employee.class, locator = EmployeeLocator.class)
public interface EmployeeProxy extends EntityProxy {

	@Override
	EntityProxyId<EmployeeProxy> stableId();

	String getName();

	void setName(String name);
        
        String getLastname();

	void setLastname(String lastname);
	
	DepartmentProxy getDepartment();
	
	void setDepartment(DepartmentProxy department);
	
	
	
}
