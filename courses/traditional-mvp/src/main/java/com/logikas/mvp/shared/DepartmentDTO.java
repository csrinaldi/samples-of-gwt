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
public class DepartmentDTO implements IsSerializable{
    
    private Long id;
    
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
