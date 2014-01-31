/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.mvp.shared.request;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.logikas.mvp.server.dao.DepartmentDao;
import com.logikas.mvp.server.locator.CustomServiceLocator;
import com.logikas.mvp.shared.proxy.DepartmentProxy;
import java.util.List;

/**
 *
 * @author scit232
 */
@Service(value = DepartmentDao.class, locator = CustomServiceLocator.class)
public interface DepartmentRequest extends RequestContext {

    Request<Void> persist(DepartmentProxy department);

    Request<Void> remove(DepartmentProxy department);

    Request<List<DepartmentProxy>> findAll();
    
}
