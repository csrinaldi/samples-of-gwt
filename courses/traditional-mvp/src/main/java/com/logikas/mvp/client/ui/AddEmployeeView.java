/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.mvp.client.ui;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasConstrainedValue;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import com.logikas.mvp.shared.DepartmentDTO;

/**
 * Description of AddEmployeeView Logikas. Conectando Ideas
 *
 * @author Cristian Rinaldi
 */
public interface AddEmployeeView extends IsWidget{

    public interface Presenter extends com.logikas.mvp.client.presenter.Presenter {

        void onSave();

        void onCancel();
    }

    HasText getName();

    HasText getLastname();
    
    HasValue<Long> getDepartment();

    void setPresenter(Presenter presenter);
    
    HasConstrainedValue<DepartmentDTO> getDepartments();
}
