/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.samples.errai.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.logikas.samples.errai.client.place.configure.TypedPlaceTokenizer;

/**
 * GWT Maven Archetype
 *
 * Documentation of Class LoginPlace
 *
 *
 * Package: com.dinaru.client.place Last modification: 12/01/2013 File:
 * LoginPlace.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class LoginPlace extends Place {

    public static class Tokenizer implements TypedPlaceTokenizer<LoginPlace> {

        @Override
        public LoginPlace getPlace(String token) {
            return new LoginPlace();
        }

        @Override
        public String getToken(LoginPlace place) {
            return "login";
        }

        @Override
        public Class<LoginPlace> getPlaceType() {
            return LoginPlace.class;
        }
    }
}
