/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.mvp.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.logikas.mvp.shared.DepartmentDTO;
import com.logikas.mvp.shared.EmployeeDTO;

/**
 *
 * @author scit232
 */
public interface MVPServiceAsync {

    public void addEmployee(EmployeeDTO employee, AsyncCallback<EmployeeDTO> callback);
    
	void finAllDepartments(AsyncCallback<List<DepartmentDTO>> callback);
    
}
