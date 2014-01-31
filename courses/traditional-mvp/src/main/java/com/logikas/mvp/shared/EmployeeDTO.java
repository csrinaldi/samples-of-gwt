/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.mvp.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 *
 * @author scit232
 */
public class EmployeeDTO implements IsSerializable{
    
    private Long id;
    
    private String name;
    
    private String lastname;
    
    private Long departmentId;

    
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
