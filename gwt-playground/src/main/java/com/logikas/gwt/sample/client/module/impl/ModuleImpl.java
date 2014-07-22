/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.gwt.sample.client.module.impl;

import com.google.gwt.core.client.js.JsExport;
import com.google.gwt.core.client.js.JsNamespace;
import com.logikas.gwt.sample.client.module.Module;

/**
 * Export Module Implementation
 *
 * @author Cristian Rinaldi <a
 * href="mailto:csrinaldi@gmail.com">csrinaldi@gmail.com</a>
 *
 * Logikas
 *
 */
@JsNamespace(value = "$wnd.Logikas")
public class ModuleImpl implements Module {

    private final String name;

    private final String version;

    @JsExport
    public ModuleImpl() {
        this.name = "default";
        this.version = "0.0.0";
    }

    @JsExport
    public ModuleImpl(String name, String version) {
        this.name = name;
        this.version = version;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVersion() {
        return version;
    }

}
