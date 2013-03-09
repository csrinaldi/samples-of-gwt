/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.samples.errai.client.view.impl;

import com.github.gwtbootstrap.client.ui.HelpInline;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Ignore;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasValue;

import com.google.gwt.user.client.ui.Widget;
import com.logikas.samples.errai.client.view.LoginUserView;
import com.logikas.samples.errai.client.view.layout.impl.MainLayoutImpl;
import javax.inject.Singleton;
import org.jboss.errai.ioc.client.api.LoadAsync;

/**
 * GWT Maven Archetype
 *
 * Documentation of Interface LoginUserWidget
 *
 *
 * Package: com.dinaru.client.view.impl Last modification: 15/01/2013 File:
 * LoginUserWidget.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 * TODO Reimplementar esto para solo que sea un Widget sin Activity por detras
 * Pasar parte de la barra de menues al Layout principal
 * @see MainLayoutImpl
 */
@LoadAsync
@Singleton
public class LoginUserWidget implements LoginUserView/*, Editor<TokenUserProxy>*/ {

    interface LoginUserUiBinder extends UiBinder<HTMLPanel, LoginUserWidget> {
    }
    private static LoginUserUiBinder uiBinder = GWT.create(LoginUserUiBinder.class);

    //interface Driver extends SimpleBeanEditorDriver<TokenUserProxy, LoginUserWidget> {
    //}
    private Presenter presenter;
    private HTMLPanel root;
    @UiField
    TextBox username;
    @UiField
    PasswordTextBox password;
    @UiField
    @Ignore
    HelpInline globalErrorInline;

    public LoginUserWidget() {
        root = uiBinder.createAndBindUi(this);
        this.globalErrorInline.setVisible(false);

    }

    @UiHandler("loginButton")
    public void onButtonLoginClick(ClickEvent event) {
        presenter.login();
    }

    public Widget asWidget() {
        return root;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public HasValue<String> getPassword() {
        return password;
    }

    public HasValue<String> getUsername() {
        return username;
    }

    /*@Override
    public SimpleBeanEditorDriver<TokenUserProxy, ? extends Editor<TokenUserProxy>> createEditorDriver() {
        Driver driver = GWT.create(Driver.class);
        driver.initialize(this);
        return driver;
    }*/

    public void showGlobalErrors(String error) {
        this.globalErrorInline.setVisible(true);
        this.globalErrorInline.setText(error);
    }
}
