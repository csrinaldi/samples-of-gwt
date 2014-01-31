package com.logikas.mvp.client.presenter;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.logikas.mvp.client.MVPServiceAsync;
import com.logikas.mvp.client.event.EmployeeUpdatedEvent;
import com.logikas.mvp.client.ui.AddEmployeeView;
import com.logikas.mvp.shared.DepartmentDTO;
import com.logikas.mvp.shared.EmployeeDTO;

public class AddEmployeePresenter implements AddEmployeeView.Presenter {

    private final AddEmployeeView view;
    private final HandlerManager eventBus;
    private MVPServiceAsync service;

    public AddEmployeePresenter(AddEmployeeView display, HandlerManager eventBus, MVPServiceAsync serviceAsync) {
        this.view = display;
        this.eventBus = eventBus;
        this.service = serviceAsync;

        this.service.finAllDepartments(new AsyncCallback<List<DepartmentDTO>>() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(List<DepartmentDTO> result) {
                view.getDepartments().setAcceptableValues(result);
            }
        });

    }

    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(view.asWidget());
    }

    @Override
    public void bind() {
        // TODO Auto-generated method stub
    }

    @Override
    public void onSave() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setName(view.getName().getText());
        dto.setLastname(view.getLastname().getText());
        dto.setDepartmentId(view.getDepartments().getValue().getId());

        this.service.addEmployee(dto, new AsyncCallback<EmployeeDTO>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(EmployeeDTO result) {
                eventBus.fireEvent(new EmployeeUpdatedEvent());
            }
        });
    }

    @Override
    public void onCancel() {
        //TODO
    }
}
