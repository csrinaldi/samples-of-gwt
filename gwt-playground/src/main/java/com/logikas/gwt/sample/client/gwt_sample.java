package com.logikas.gwt.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;
import com.logikas.gwt.sample.client.databinding.PathObserver;
import com.logikas.gwt.sample.client.model.Employee;
import com.logikas.gwt.sample.client.model.Person;
import com.logikas.gwt.sample.client.model.datatable.OptionConfig;
import com.logikas.gwt.sample.client.model.datatable.DataTableElement;
import com.workingflows.js.jscore.client.api.Function;
import com.workingflows.js.jscore.client.factory.JS;

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

    @JsType
    public interface JFunction {

        Object f(Object... o);
    }

    @JsType
    public interface Promise {

        Promise when(JFunction f);

        void done(JFunction f);

    }

    @JsType(prototype = "jQuery")
    public interface JQueryElement {

        JQueryElement append(JQueryElement element);

        @JsProperty
        JQueryElement html();

        void data(String key, String value);

        Promise promise();

        DataTableElement DataTable(OptionConfig config);

        //DataTableElement DataTable();
    }

    public interface BootstrapSwichElement extends JQueryElement {

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

        final HTMLElement div = doc.createElement("DIV");
        final HTMLElement p = doc.createElement("P");
        final HTMLElement input = doc.createElement("input");
        final HTMLElement button = doc.createElement("button");

        final Person person = new Person();
        person.setName("Cristian");
        /*final PathObserver<Person, String> observer = PathObserverFactory.createPathObserver(person, "name");
         input.bind("value", observer);
         final PathObserver<Person, String> observer1 = PathObserverFactory.createPathObserver(person, "name");
         final String original = observer1.open(PathObserverFactory.createOpenPathObserverListener(new OpenPathObserverListener<Person>() {
         @Override
         public void onOpen(String newValue, String oldValue) {
         HTMLElement p = doc.createElement("P");
         p.setInnerText("The new Value is: " + newValue);
         body.appendChild(p);
         }
         }), person);*/

        button.setInnerText("Clear changes");

        window().getConsole().log("Definiendo Observe .... ");
        window().getConsole().log(JS.Object);
        
        JS.Object.observe(person, JS.Function(new Function() {
            @Override
            public void f(Object... changed) {
                window().getConsole().log("Changed Person .... ");
                window().getConsole().log(changed);
                window().getConsole().log("Changed Person .... ");
            }
        }));
        
        window().getConsole().log("Definido Observe .... ");

        div.appendChild(p);
        div.appendChild(input);
        body.appendChild(div);
        body.appendChild(button);

        JQueryElement checked = $("<input type='checkbox' checked></input>");
        checked.data("on-text", "SI");
        checked.data("off-text", "NO");
        $("body").append(checked);

        JQueryElement r = $("<div>");

        r.promise().done(Fn(new JFunction() {
            @Override
            public Object f(Object... o) {
                return true;
            }
        }, "Cristian", "Rinaldi"));

        final Employee employee = new Employee("Cristian", "202223232");

        /*final ObjectObserver<Employee> objectObserver = PathObserverFactory.createObjectObserver(employee);
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
         }), employee);*/
        employee.setCuit("nnnnn");
        employee.setName("Vamos");

        person.setEmail("hola");
        person.setName("fff");

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

    public static native JFunction Fn(JFunction f, Object... params)/*-{
     return function(){
     f.f(params);
     }
     }-*/;

    public static native BootstrapSwichElement bootstrapSwich(JQueryElement element, JsObject options) /*-{
     return new $wnd.$.fn.bootstrapSwitch.Constructor(element, options);
     }-*/;

    public static native JQueryElement $(String selector) /*-{
     return $wnd.$(selector);
     }-*/;

    public static native String toJson(com.logikas.gwt.sample.client.model.JsObject object) /*-{
     return JSON.stringify(object);
     }-*/;

}
