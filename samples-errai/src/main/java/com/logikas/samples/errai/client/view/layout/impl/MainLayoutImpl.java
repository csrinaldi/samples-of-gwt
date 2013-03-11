package com.logikas.samples.errai.client.view.layout.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.github.gwtbootstrap.client.ui.Nav;
import com.github.gwtbootstrap.client.ui.NavCollapse;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.Navbar;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.uibinder.client.UiHandler;
import com.logikas.samples.errai.client.presenter.LoginActivity;
import com.logikas.samples.errai.client.view.layout.MainLayout;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

public class MainLayoutImpl implements MainLayout, MainLayout.Presenter {

    private static MainLayoutUiBinder uiBinder = GWT.create(MainLayoutUiBinder.class);

    interface MainLayoutUiBinder extends UiBinder<Widget, MainLayoutImpl> {
    }
    @UiField
    Navbar responsiveNavbar;
    @UiField
    NavLink buttonRegister;
    @UiField
    NavLink buttonLogout;
    @UiField
    NavCollapse navLogin;
    @UiField
    Nav navLogout;
    @UiField
    Nav navSingUp;
    @UiField
    ScrollPanel center;
    //@UiField
    //LoginUserWidget loginUserWidget;
    private final Widget mainLayout;
    @UiField
    NavLink homeButton;
    @UiField
    NavLink objetiveButton;
    @UiField
    NavLink movementsButton;
    @UiField
    NavLink analysisButton;
    @UiField
    NavLink savingButton;
    @UiField
    NavLink transactionsButton;
    @UiField
    NavLink accountsButton;
    PlaceController placeController;
    @UiField
    ScrollPanel popupRegion;
    
    //AccountEditView accountEditView;

    @Inject
    public MainLayoutImpl(
            final PlaceHistoryMapper mapper, 
            final PlaceController controller, 
            final EventBus eventBus, 
            final LoginActivity activity,
            final AccountEditView accountEditView) {
        mainLayout = uiBinder.createAndBindUi(this);

        navLogout.setVisible(false);

        homeButton.setVisible(false);
        objetiveButton.setVisible(false);
        movementsButton.setVisible(false);
        analysisButton.setVisible(false);
        savingButton.setVisible(false);
        transactionsButton.setVisible(false);
        accountsButton.setVisible(false);

        //TODO ver si esto lo ponemos en el presenter
        RegisterPlace p = new RegisterPlace();
        buttonRegister.setTargetHistoryToken(mapper.getToken(p));

        this.accountEditView = accountEditView;

        //TODO lanzar evento de Logout para hacer operaciones
        buttonLogout.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                SecurityContext.invalidate();
                processLogin(false);

                homeButton.setActive(true);
                controller.goTo(new HomePlace());
                
                //TODO generalizar el clear de ingerface ....
                accountEditView.clearView();

            }
        });

        eventBus.addHandler(LoginEventSuccess.TYPE, new LoginEventSuccessHandler() {
            public void onSuccess(TokenAccessProxy proxy) {
                processLogin(true);
                Browser.getWindow().getConsole().log("userId " +SecurityContext.getUserId());
                Browser.getWindow().getConsole().log("tokenId " +SecurityContext.getToken());
                homeButton.setActive(true);
                placeController.goTo(new DashboardPlace());
            }
        });

        //activity.prepareView(loginUserWidget);
        
        center.getElement().setId("center");
        popupRegion.getElement().setId("popup");

        this.placeController = controller;
    }

    private void processLogin(Boolean state) {
        navLogin.setVisible(!state);
        navSingUp.setVisible(!state);
        navLogout.setVisible(state);

        homeButton.setVisible(state);
        //objetiveButton.setVisible(state);
        //movementsButton.setVisible(state);
        //analysisButton.setVisible(state);
        //savingButton.setVisible(state);
        transactionsButton.setVisible(state);
        accountsButton.setVisible(state);

    }

    @Override
    public AcceptsOneWidget getCenterReqion() {
        return new AcceptsOneWidget() {
            @Override
            public void setWidget(IsWidget w) {
                Widget widget = Widget.asWidgetOrNull(w);
                center.setWidget(widget);
            }
        };
    }

    @Override
    public AcceptsOneWidget getPopupRegion() {
        return new AcceptsOneWidget() {
            @Override
            public void setWidget(IsWidget w) {
                Widget widget = Widget.asWidgetOrNull(w);
                popupRegion.setWidget(widget);
            }
        };
    }

    @Override
    public Widget asWidget() {
        return mainLayout;
    }

    /**
     * Renderiza el Layout por defecto
     */
    @Override
    public void setDefaultLayout() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void goToRegister() {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    public void setPresenter(Presenter presenter) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    @UiHandler("homeButton")
    public void onClickHomeButton(ClickEvent event) {
        disableAllButton();
        homeButton.setActive(true);
        placeController.goTo(new DashboardPlace());

    }

    @UiHandler("objetiveButton")
    public void onClickObjetiveButton(ClickEvent event) {
        disableAllButton();
        objetiveButton.setActive(true);
    }

    @UiHandler("accountsButton")
    public void onClickAccountsButton(ClickEvent event) {
        disableAllButton();
        accountsButton.setActive(true);
        placeController.goTo(new AccountListPlace());
    }

    @UiHandler("transactionsButton")
    public void onClickTransactionsButton(ClickEvent event) {
        disableAllButton();
        transactionsButton.setActive(true);
        placeController.goTo(new TransactionListPlace());
    }

    private void disableAllButton() {
        homeButton.setActive(false);
        objetiveButton.setActive(false);
        movementsButton.setActive(false);
        analysisButton.setActive(false);
        savingButton.setActive(false);
        transactionsButton.setActive(false);
        accountsButton.setActive(false);
    }

    public void setPopupLayout(Boolean state) {
        if (state) {
            Browser.getWindow().getConsole().log(popupRegion);
            popupRegion.setWidth(String.valueOf(center.getOffsetWidth()) + "px");
            popupRegion.setHeight(String.valueOf(center.getOffsetHeight()) + "px");
            Browser.getWindow().getConsole().log(popupRegion);
        } else {
            popupRegion.setWidth("0px");
            popupRegion.setHeight("0px");
        }
    }
}
