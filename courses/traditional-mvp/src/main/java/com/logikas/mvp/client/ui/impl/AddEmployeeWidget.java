/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.mvp.client.ui.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.logikas.mvp.client.ui.AddEmployeeView;
import com.logikas.mvp.shared.DepartmentDTO;

/**
 * Description of AddEmployeeWidget Logikas. Conectando Ideas
 *
 * @author Cristian Rinaldi
 */
public class AddEmployeeWidget implements AddEmployeeView {

    private static AddEmployeeWidget.AddEmployeeWidgetUiBinder uiBinder = GWT.create(AddEmployeeWidget.AddEmployeeWidgetUiBinder.class);

    interface AddEmployeeWidgetUiBinder extends UiBinder<HTMLPanel, AddEmployeeWidget> {
    }
    @UiField
    Button saveButton;
    
    @UiField
    TextBox name;
    
    @UiField
    TextBox lastname;
    
    @UiField
    HasConstrainedValue<DepartmentDTO> departments;
    
    private Presenter presenter;

    private HTMLPanel root;

    public AddEmployeeWidget() {
        root = uiBinder.createAndBindUi(this);
    }

    @Override
    public HasText getName() {
        return name;
    }

    @Override
    public HasText getLastname() {
        return lastname;
    }

    @Override
    public Widget asWidget() {
        return root;
    }
    
    @Override
    public HasValue<Long> getDepartment() {
        return null;
    }
    
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

	@Override
	public HasConstrainedValue<DepartmentDTO> getDepartments() {
		return departments;
	}
	
	@UiHandler("cancelButton")
	void onCancelButtonClick(ClickEvent event){
		presenter.onCancel();
	}
	
	@UiHandler("saveButton")
	void onSaveButtonClick(ClickEvent event){
		presenter.onSave();
	}
}
