/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.mvp.server;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.logikas.mvp.client.MVPService;
import com.logikas.mvp.server.dao.DepartmentDao;
import com.logikas.mvp.server.dao.EmployeeDao;
import com.logikas.mvp.server.domain.Department;
import com.logikas.mvp.server.domain.Employee;
import com.logikas.mvp.shared.DepartmentDTO;
import com.logikas.mvp.shared.EmployeeDTO;

/**
 *
 * @author scit232
 */
@Singleton
public class MVPServiceImpl extends RemoteServiceServlet implements MVPService {

    private static final long serialVersionUID = 1L;

    private final EmployeeDao employeeDao;
    private final DepartmentDao departmentDao;

    @Inject
    public MVPServiceImpl(EmployeeDao employeeDao, DepartmentDao departmentDao) {
        this.employeeDao = employeeDao;
        this.departmentDao = departmentDao;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDto) {

        Long departmentId = employeeDto.getDepartmentId();
        Department department = departmentDao.findById(departmentId);

        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setLastname(employeeDto.getLastname());
        employee.setDepartment(department);

        employeeDao.persist(employee);

        employeeDto.setId(employee.getId());

        return employeeDto;

    }

    @Override
    public List<DepartmentDTO> finAllDepartments() {
        List<DepartmentDTO> result = new LinkedList<DepartmentDTO>();
        List<Department> departmens = departmentDao.findAll();
        Iterator<Department> it = departmens.iterator();
        while (it.hasNext()) {
            Department department = (Department) it.next();
            DepartmentDTO dto = new DepartmentDTO();
            dto.setId(department.getId());
            dto.setName(department.getName());
            result.add(dto);
        }

        return result;
    }

}
