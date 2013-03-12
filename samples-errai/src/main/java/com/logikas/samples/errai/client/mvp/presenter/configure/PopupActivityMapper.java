/*
 * Copyright 2013 JBoss, a division of Red Hat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.logikas.samples.errai.client.mvp.presenter.configure;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.logikas.samples.errai.client.mvp.presenter.LoginActivity;
import javax.inject.Inject;
import javax.inject.Provider;

/**
 *
 * @author cristian
 */
public class PopupActivityMapper implements ActivityMapper {

    private final Provider<LoginActivity> loginActivity;

    @Inject
    public PopupActivityMapper(
            final Provider<LoginActivity> loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Override
    public Activity getActivity(Place place) {
        return null;
    }
    
}
