/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.samples.errai.client.presenter;


import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.logikas.samples.errai.client.view.LoginUserView;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Singleton;

/**
 * GWT Maven Archetype
 *
 * Documentation of Class LoginActivity
 *
 *
 * Package: com.dinaru.client.presenter Last modification: 12/01/2013 File:
 * LoginActivity.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */

public class LoginActivity extends AbstractActivity implements LoginUserView.Presenter {

    final private LoginUserView view;

    @Inject
    public LoginActivity(LoginUserView loginView) {
        this.view = loginView;
    }
    
    @PostConstruct
    private void init(){
        if ( view != null ){
            GWT.log("LoginView injected");
        }
    }

    @Override
    public void start(final AcceptsOneWidget panel, EventBus eventBus) {
        
        GWT.log("Starting Activity ....");
        
        /*loginView.get(new Callback<LoginUserView, Throwable>(){
            
        });
        loginView.get(new AsyncCallback<LoginUserView>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(LoginUserView result) {
                panel.setWidget(result);
                prepareView(result);
            }
        });*/
    }

    public void prepareView(final LoginUserView widget) {
        widget.setPresenter(this);
        //this.view = widget;
        //driver = this.view.createEditorDriver();
        //proxy = new TokenUserProxy();
        //driver.edit(proxy);
    }

    @Override
    public void login() {
        //proxy = driver.flush();
        view.getPassword().setValue("");
        view.getUsername().setValue("");

        //TODO ver si lo metemos con los errores de cliente
        /*if (driver.hasErrors()) {
            view.showGlobalErrors("Error en las Credenciales");
        } else {
            Resource resource = new Resource(this.serviceBackend);
            UserService service = GWT.create(UserService.class);
            ((RestServiceProxy) service).setResource(resource);

            service.login(proxy, new MethodCallback<TokenAccessProxy>() {
                public void onFailure(Method method, Throwable exception) {
                    view.showGlobalErrors("Error en las Credenciales");
                }

                public void onSuccess(Method method, TokenAccessProxy response) {
                    SecurityContext.setToken(response.getToken());
                    SecurityContext.setUserId(response.getUserId());
                    //TODO guardar el token de acceso 
                    //DashboardPlace place = new DashboardPlace();
                    //placeController.goTo(place);
                    bus.fireEvent(new LoginEventSuccess(response));
                    
                }
            });
        }*/

        /*if (this.view.getUsername().getValue().equals("") & this.view.getPassword().getValue().equals("")) {
         Window.alert("No pueden ser null");
         } else {
         //Cookies.setCookie("sid", null);
         }*/
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void goTo(Place place) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
