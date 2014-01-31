package com.logikas.mvp.shared.request;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface MVPRequestFactory extends RequestFactory {

    EmployeeRequest userRequest();

    DepartmentRequest departmentRequest();
}
