package com.logikas.samples.errai.client.mvp.presenter.configure;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.logikas.samples.errai.client.mvp.place.LoginPlace;
import com.logikas.samples.errai.client.mvp.presenter.LoginActivity;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class CenterActivityMapper implements ActivityMapper {

    private final Provider<LoginActivity> loginActivity;

    @Inject
    public CenterActivityMapper(
            final Provider<LoginActivity> loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof LoginPlace) {
            return loginActivity.get();
        }

        return null;
    }
}
