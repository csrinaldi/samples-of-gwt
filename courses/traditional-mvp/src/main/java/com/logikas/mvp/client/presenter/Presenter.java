/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.mvp.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Description of Presenter
 * Logikas. Conectando Ideas
 * @author Cristian Rinaldi
 */
public interface Presenter {
    public void go(HasWidgets container);
    public void bind();
}
