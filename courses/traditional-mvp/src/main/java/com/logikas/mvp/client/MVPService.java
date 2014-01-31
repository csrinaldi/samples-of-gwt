/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.mvp.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.logikas.mvp.shared.DepartmentDTO;
import com.logikas.mvp.shared.EmployeeDTO;

/**
 *
 * @author scit232
 */
@RemoteServiceRelativePath("services")
public interface MVPService extends RemoteService {

    EmployeeDTO addEmployee(EmployeeDTO employee);

    List<DepartmentDTO> finAllDepartments();

}
