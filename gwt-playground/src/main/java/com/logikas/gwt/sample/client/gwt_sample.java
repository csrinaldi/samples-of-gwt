package com.logikas.gwt.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;
import com.google.gwt.user.client.DOM;
import com.logikas.gwt.sample.client.model.Handler;
import com.logikas.gwt.sample.client.model.PathObserverFactory;
import com.logikas.gwt.sample.client.model.Person;

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

        public void alert(String hola);
    }

    @JsType(prototype = "HTMLBodyElement")
    public interface HTMLBodyElement extends HTMLElement {

    }

    @JsType(prototype = "Object")
    public interface JsObject {
    }

    @JsType(prototype = "EventTarget")
    public interface EventTarget extends JsObject {

    }

    @JsType(prototype = "Node")
    public interface Node extends EventTarget {

        void bind(String property, PathObserver observer);
    }

    @JsType(prototype = "Element")
    public interface Element extends Node {

    }

    public interface EventListener<E extends JsObject> {

        void onEvent(E event);
    }

    public interface OpenObserverListener {

        void onOpen(String oldValue, String newValue);
    }

    @JsType(prototype = "HTMLElement")
    public interface HTMLElement extends Element {

        public void setAttribute(String align, String center);

        public void appendChild(HTMLElement element);

        public void addEventListener(String event, EventListener<? extends JsObject> handler);

        @JsProperty
        public void setInnerHTML(String text);

        @JsProperty
        public void setInnerText(String text);

    }

    @JsType(isNative = true, prototype = "Document")
    public interface Document {

        public HTMLElement createElement(String div);

        public HTMLElement getElementsByTagName(String body);

    }

    @JsType(prototype = "PathObserver")
    public interface PathObserver {

        void open(OpenObserverListener handler);

    }

    @Override
    public void onModuleLoad() {
        Document doc = getDocument();
        HTMLElement div = doc.createElement("DIV");
        HTMLElement p = doc.createElement("P");
        HTMLElement input = doc.createElement("input");
        HTMLElement button = doc.createElement("button");
        HTMLBodyElement body = bodyElement();

        final Person person = new Person();
        PathObserver observer = PathObserverFactory.createObserver(person, "name");
        input.bind("value", observer);

        PathObserver observer1 = PathObserverFactory.createObserver(person, "name");
        observer1.open(new OpenObserverListener() {
            @Override
            public void onOpen(String oldValue, String newValue) {
                window().getConsole().log(oldValue);
            }
        });

        person.setName("Cristian");
        person.setName("Cristiaa");

        button.setInnerText("UPDATE - See the console");

        button.addEventListener("click", new EventListener<JsObject>() {
            @Override
            public void onEvent(JsObject event) {
                window().getConsole().log(event);
            }
        });

        window().getConsole().log("%cWelcome to JSInterop!%c", "font-size:1.5em;color:#4558c9;", "color:#d61a7f;font-size:1em;");

        div.appendChild(p);
        div.appendChild(input);
        body.appendChild(div);
        body.appendChild(button);
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
