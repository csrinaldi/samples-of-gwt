package com.logikas.mvp.shared.request;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.logikas.mvp.server.dao.EmployeeDao;
import com.logikas.mvp.server.locator.CustomServiceLocator;
import com.logikas.mvp.shared.proxy.EmployeeProxy;

@Service(value = EmployeeDao.class, locator = CustomServiceLocator.class)
public interface EmployeeRequest extends RequestContext {

    Request<Void> persist(EmployeeProxy employee);

    Request<Void> remove(EmployeeProxy employee);

    Request<List<EmployeeProxy>> findAll();
}
