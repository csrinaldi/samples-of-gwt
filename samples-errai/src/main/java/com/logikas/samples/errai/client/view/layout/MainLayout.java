package com.logikas.samples.errai.client.view.layout;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

public interface MainLayout extends IsWidget {

    interface Presenter {

        void goToRegister();
    }

    AcceptsOneWidget getCenterReqion();
    
    AcceptsOneWidget getPopupRegion();

    void setDefaultLayout();

    void setPresenter(Presenter presenter);
    
    void setPopupLayout(Boolean state);
}
