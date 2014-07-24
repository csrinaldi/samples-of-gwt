package com.logikas.gwt.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;
import com.logikas.gwt.sample.client.databinding.ObjectObserver;
import com.logikas.gwt.sample.client.databinding.PathObserver;
import com.logikas.gwt.sample.client.databinding.factory.PathObserverFactory;
import com.logikas.gwt.sample.client.databinding.listener.OpenObjectObserverListener;
import com.logikas.gwt.sample.client.databinding.listener.OpenPathObserverListener;
import com.logikas.gwt.sample.client.model.Employee;
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

    @JsType
    public interface EventListener<E extends JsObject> {

        void onEvent(E event);
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

    @Override
    public void onModuleLoad() {
        final Document doc = getDocument();
        final HTMLBodyElement body = bodyElement();

        HTMLElement div = doc.createElement("DIV");
        HTMLElement p = doc.createElement("P");
        HTMLElement input = doc.createElement("input");
        HTMLElement button = doc.createElement("button");

        final Person person = new Person();
        person.setName("Cristian");
        final PathObserver<Person, String> observer = PathObserverFactory.createPathObserver(person, "name");
        input.bind("value", observer);
        final PathObserver<Person, String> observer1 = PathObserverFactory.createPathObserver(person, "name");
        final String original = observer1.open(PathObserverFactory.createOpenPathObserverListener(new OpenPathObserverListener<Person>() {
            @Override
            public void onOpen(String newValue, String oldValue) {
                HTMLElement p = doc.createElement("P");
                p.setInnerText("The new Value is: " + newValue);
                body.appendChild(p);
            }
        }), person);

        button.setInnerText("Clear changes");

        button.addEventListener("click", EventListenerFactory.createEventListener(new EventListener<JsObject>() {
            @Override
            public void onEvent(JsObject event) {
                String actualValue = observer.discardChanges();
                window().getConsole().log(original);
                observer.close();
                observer1.close();
                HTMLElement p = doc.createElement("P");
                p.setInnerText("The Actual Value of Observation is: " + actualValue + " and the Original Value if property name is: " + original);
                body.appendChild(p);
            }
        }));

        window().getConsole().log("%cWelcome to JSInterop!%c", "font-size:1.5em;color:#4558c9;", "color:#d61a7f;font-size:1em;");

        div.appendChild(p);
        div.appendChild(input);
        body.appendChild(div);
        body.appendChild(button);
        
        final Employee employee = new Employee("Cristian", "202223232");
        
        final ObjectObserver<Employee> objectObserver = PathObserverFactory.createObjectObserver(employee);
        objectObserver.open(PathObserverFactory.createOpenObjectObserverListener(new OpenObjectObserverListener<Employee>() {
            @Override
            public void onOpen(JsArray added, JsArray removed, JsArray changed) {
                window().getConsole().log("Added +++ ");
                window().getConsole().log(added);
                window().getConsole().log("Added --- ");
                window().getConsole().log("Removed +++ ");
                window().getConsole().log(removed);
                window().getConsole().log("Removed --- ");
                window().getConsole().log("Changed +++ ");
                window().getConsole().log(changed);
                window().getConsole().log("Changed --- ");
            }
        }), employee);

        employee.setCuit("nnnnn");
        employee.setName("Vamos");
        
        window().getConsole().log(objectObserver.discardChanges());
        
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
