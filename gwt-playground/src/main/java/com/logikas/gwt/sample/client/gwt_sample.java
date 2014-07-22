package com.logikas.gwt.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class gwt_sample implements EntryPoint {

    @JsType(prototype = "Console")
    public interface Console {

        void log(Object object, String... params);
    }

    @JsType(prototype = "Window")
    public interface Window {

        @JsProperty(value = "console")
        Console getConsole();
    }

    @JsType(prototype = "HTMLBodyElement")
    public interface HTMLBodyElement extends HTMLElement {

    }

    @JsType(prototype = "HTMLElement")
    public interface HTMLElement {

        public void setAttribute(String align, String center);

        public void appendChild(HTMLElement element);

    }

    @JsType(isNative = true, prototype = "Document")
    public interface Document {

        public HTMLElement createElement(String div);

        public HTMLElement getElementsByTagName(String body);

    }

    @Override
    public void onModuleLoad() {
        Document doc = getDocument();
        HTMLElement div = doc.createElement("DIV");
        HTMLElement p = doc.createElement("P");
        div.appendChild(p);
        HTMLBodyElement body = bodyElement();
        body.appendChild(div);

        window().getConsole().log("%cWelcome to JSInterop!%c", "font-size:1.5em;color:#4558c9;", "color:#d61a7f;font-size:1em;");

        newJSModule();

    }

    public static native void newJSModule()/*-{
            var module = new $wnd.Logikas.ModuleImpl("m", "1.0.0");
            console.log(module);
            console.log(module.getName());
     }-*/;

    public static native Document getDocument() /*-{
     return $wnd.document;
     }-*/;

    public static native HTMLBodyElement bodyElement() /*-{
     return $wnd.document.body;
     }-*/;

    public static native Window window() /*-{
     return $wnd;
     }-*/;
}
