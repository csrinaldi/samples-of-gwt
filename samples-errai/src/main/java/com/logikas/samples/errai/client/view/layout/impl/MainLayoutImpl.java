package com.logikas.samples.errai.client.view.layout.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.*;
import com.google.common.base.Preconditions;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.logikas.samples.errai.client.view.LoginUserView;
import com.logikas.samples.errai.client.view.layout.MainLayout;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MainLayoutImpl implements MainLayout, MainLayout.Presenter {

    /**
     * TODO ver si se hace con un producer para todas las interfaces y luego la inyectamos
     */
    private static MainLayoutUiBinder uiBinder = GWT.create(MainLayoutUiBinder.class);

    interface MainLayoutUiBinder extends UiBinder<Widget, MainLayoutImpl> {
    }
    
    /*@UiField
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
    
    //AccountEditView accountEditView;*/
    
    //@UiField
    //FluidContainer container;

    private Widget mainLayout;
    
    //@Inject
    //private PlaceHistoryMapper mapper;
    
    //@Inject
    //private PlaceController controller;
    
    @Inject
    private EventBus bus;
    
    @Inject
    private LoginUserView.Presenter activity;
    
    @PostConstruct
    public void init() {
        
        LoginUserView.Presenter la = Preconditions.checkNotNull(activity, "Login Activity is null");
        GWT.log(la.toString() + " Injected");
        
        bus = Preconditions.checkNotNull(bus, "EventBus Activity is null");
        GWT.log(bus.toString() + " Injected");
        
        uiBinder = Preconditions.checkNotNull(uiBinder, "MainLayout is null");
        GWT.log(uiBinder.toString() + " Injected");
        
        mainLayout = uiBinder.createAndBindUi(this);
        
        //container = Preconditions.checkNotNull(container, "Container is null");
        //GWT.log(container.toString() + " Injected");
        
        
        
       // mainLayout = uiBinder.createAndBindUi(this);

        /*navLogout.setVisible(false);

        homeButton.setVisible(false);
        objetiveButton.setVisible(false);
        movementsButton.setVisible(false);
        analysisButton.setVisible(false);
        savingButton.setVisible(false);
        transactionsButton.setVisible(false);
        accountsButton.setVisible(false);*/

        //TODO ver si esto lo ponemos en el presenter
        //RegisterPlace p = new RegisterPlace();
        //buttonRegister.setTargetHistoryToken(mapper.getToken(p));

        //this.accountEditView = accountEditView;

        //TODO lanzar evento de Logout para hacer operaciones
       // buttonLogout.addClickHandler(new ClickHandler() {
       //     public void onClick(ClickEvent event) {
                /*SecurityContext.invalidate();
                processLogin(false);

                homeButton.setActive(true);
                controller.goTo(new HomePlace());
                
                //TODO generalizar el clear de ingerface ....
                accountEditView.clearView();
                **/ 
       //     }
       // });

        /*eventBus.addHandler(LoginEventSuccess.TYPE, new LoginEventSuccessHandler() {
            public void onSuccess(TokenAccessProxy proxy) {
                processLogin(true);
                Browser.getWindow().getConsole().log("userId " +SecurityContext.getUserId());
                Browser.getWindow().getConsole().log("tokenId " +SecurityContext.getToken());
                homeButton.setActive(true);
                placeController.goTo(new DashboardPlace());
            }
        });*/

        //activity.prepareView(loginUserWidget);
        
        //center.getElement().setId("center");
        //popupRegion.getElement().setId("popup");

        //this.placeController = controller;
    }

    private void processLogin(Boolean state) {
        /*navLogin.setVisible(!state);
        navSingUp.setVisible(!state);
        navLogout.setVisible(state);

        homeButton.setVisible(state);
        //objetiveButton.setVisible(state);
        //movementsButton.setVisible(state);
        //analysisButton.setVisible(state);
        //savingButton.setVisible(state);
        transactionsButton.setVisible(state);
        accountsButton.setVisible(state);*/

    }

    @Override
    public AcceptsOneWidget getCenterReqion() {
        return new AcceptsOneWidget() {
            @Override
            public void setWidget(IsWidget w) {
                Widget widget = Widget.asWidgetOrNull(w);
                //center.setWidget(widget);
            }
        };
    }

    @Override
    public AcceptsOneWidget getPopupRegion() {
        return new AcceptsOneWidget() {
            @Override
            public void setWidget(IsWidget w) {
                Widget widget = Widget.asWidgetOrNull(w);
                //popupRegion.setWidget(widget);
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

    //@UiHandler("homeButton")
    public void onClickHomeButton(ClickEvent event) {
        /*disableAllButton();
        homeButton.setActive(true);
        placeController.goTo(new DashboardPlace());
        * */
    }

    //@UiHandler("objetiveButton")
    public void onClickObjetiveButton(ClickEvent event) {
        disableAllButton();
       //objetiveButton.setActive(true);
    }

    //@UiHandler("accountsButton")
    public void onClickAccountsButton(ClickEvent event) {
        /*disableAllButton();
        accountsButton.setActive(true);
        placeController.goTo(new AccountListPlace());*/
    }

    //@UiHandler("transactionsButton")
    public void onClickTransactionsButton(ClickEvent event) {
        /*disableAllButton();
        transactionsButton.setActive(true);
        placeController.goTo(new TransactionListPlace());*/
    }

    private void disableAllButton() {
        /*homeButton.setActive(false);
        objetiveButton.setActive(false);
        movementsButton.setActive(false);
        analysisButton.setActive(false);
        savingButton.setActive(false);
        transactionsButton.setActive(false);
        accountsButton.setActive(false);*/
    }

    public void setPopupLayout(Boolean state) {
        /*if (state) {
            Browser.getWindow().getConsole().log(popupRegion);
            popupRegion.setWidth(String.valueOf(center.getOffsetWidth()) + "px");
            popupRegion.setHeight(String.valueOf(center.getOffsetHeight()) + "px");
            Browser.getWindow().getConsole().log(popupRegion);
        } else {
            popupRegion.setWidth("0px");
            popupRegion.setHeight("0px");
        }*/
    }
}
