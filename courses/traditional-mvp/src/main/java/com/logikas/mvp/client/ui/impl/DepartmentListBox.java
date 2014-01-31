package com.logikas.mvp.client.ui.impl;

import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.user.client.ui.ValueListBox;
import com.logikas.mvp.shared.DepartmentDTO;

public class DepartmentListBox extends ValueListBox<DepartmentDTO> {

	static class DepartmentRenderer extends AbstractRenderer<DepartmentDTO> {

		@Override
		public String render(DepartmentDTO arg0) {
			return arg0.getName();
		}

	}

	public DepartmentListBox() {
		super(new DepartmentRenderer());
	}

}
