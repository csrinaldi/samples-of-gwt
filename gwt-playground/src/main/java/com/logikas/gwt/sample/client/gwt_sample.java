package com.logikas.gwt.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.logikas.gwt.sample.client.model.Employee;
import com.workingflows.js.bootstraps.client.BootstrapSwitchElement;
import com.workingflows.js.bootstraps.client.factory.BootstrapFactory;
import com.workingflows.js.jquery.client.api.JQueryElement;
import static com.workingflows.js.jquery.client.factory.Factories.$;
import com.workingflows.js.jscore.client.api.Document;
import com.workingflows.js.jscore.client.api.Function;
import com.workingflows.js.jscore.client.api.html.HTMLBodyElement;
import com.workingflows.js.jscore.client.api.html.HTMLElement;
import com.workingflows.js.jscore.client.factory.Browser;
import com.workingflows.js.jscore.client.factory.JS;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class gwt_sample implements EntryPoint {

    @Override
    public void onModuleLoad() {

        final Document doc = Browser.getDocument();
        final HTMLBodyElement body = doc.getBody();

        final HTMLElement div = doc.createElement("DIV");
        final HTMLElement p = doc.createElement("P");
        final HTMLElement input = doc.createElement("input");
        final HTMLElement button = doc.createElement("button");

        /*final Person person = new Person();
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

         JS.Object.observe(person, JS.Function(new Function<Array, Object>() {
         @Override
         public Object f(Array changed) {
         return null;
         }
         }));

         Browser.getWindow().getConsole().log("%cWelcome to JSInterop!%c", "font-size:1.5em;color:#4558c9;", "color:#d61a7f;font-size:1em;");

         Browser.getWindow().getConsole().log("Definido Observe .... ");

         div.appendChild(p);
         div.appendChild(input);
         body.appendChild(div);
         body.appendChild(button);*/
        JQueryElement checked = $("<input type='checkbox' id='c' checked></input>");
        $("body").append(checked);

        final BootstrapSwitchElement b = BootstrapFactory.BootstrapSwitch("#c");
        b.bootstrapSwitch(BootstrapSwitchElement.ONTEXT, "SI");
        b.bootstrapSwitch(BootstrapSwitchElement.OFFTEXT, "NO");
        b.on(BootstrapSwitchElement.initEvent, JS.Function(new Function<Object, Void>() {
            @Override
            public Void f(Object changed) {
                Browser.getWindow().getConsole().log(b.getState());
                return null;
            }
        }));

        //BootstrapSwichElement bse = bootstrapSwich(checked, Browser.newObject());
        final Employee employee = new Employee("Cristian", "202223232");

        /*person.setEmail("hola");
         person.setName("fff");

         Promise p1 = Browser.newPromise(JS.Function(new PromiseFn() {
         @Override
         public void f(Resolve resolve, Rejected rejected) {
         resolve.resolve("Resolve Promise P1");
         }
         }));

         final Promise p3 = Browser.newPromise(JS.Function(new PromiseFn() {
         @Override
         public void f(Resolve resolve, Rejected rejected) {
         resolve.resolve("Resolve Promise P3");
         }
         }));

         p1.then(
         JS.Function(
         new PromiseThenFn() {
         @Override
         public Promise f(final Object changed) {
         Browser.getWindow().getConsole().log("Promise Complete: " + changed);
         return Browser.newPromise(JS.Function(new PromiseFn() {
         @Override
         public void f(Resolve resolve, Rejected rejected) {
         resolve.resolve(changed + " > Other Promise");
         }
         }));
         }
         }), JS.Function(
         new PromiseThenFn() {
         @Override
         public Promise f(final Object changed) {
         Browser.getWindow().getConsole().log("Promise with Error: " + changed);
         return Browser.newPromise(JS.Function(new PromiseFn() {
         @Override
         public void f(Resolve resolve, Rejected rejected) {
         rejected.rejected(changed + " > Other With Error Promise");
         }
         }));
         }
         })
         ).then(
         JS.Function(
         new PromiseThenFn() {
         @Override
         public Promise f(final Object changed) {
         Browser.getWindow().getConsole().log("Promise Complete: " + changed);
         return null;
         }
         }), JS.Function(
         new PromiseThenFn() {
         @Override
         public Promise f(Object changed) {
         Browser.getWindow().getConsole().log("Promise with Error: " + changed);
         return null;
         }
         })
         );

         JS.Promise.all(true, p1, p3).then(JS.Function(
         new PromiseThenFn() {
         @Override
         public Promise f(Object changed) {
         Browser.getWindow().getConsole().log("Promise Complete: " + changed);
         return null;
         }
         }),
         JS.Function(new PromiseThenFn() {
         @Override
         public Promise f(Object changed) {
         Browser.getWindow().getConsole().log("Promise Error: " + changed);
         return null;
         }
         }));

         final List<String> list = new ArrayList<>();

         Config conf = MultiSelect.config(
         Boolean.TRUE,
         Boolean.TRUE,
         MultiSelect.Function(new SelectOrDeselectFunction() {
         @Override
         public void f(String changed) {
         com.google.gwt.user.client.Window.alert(changed);
         list.add(changed);
         }

         }),
         MultiSelect.Function(new SelectOrDeselectFunction() {
         @Override
         public void f(String changed) {
         com.google.gwt.user.client.Window.alert(changed);
         list.remove(changed);
         }
         }));

         //SelectElement select = (SelectElement) $("#my-select");
         MultiSelect mselect = MultiSelect.create("#my-select", conf);
         mselect.addOption(MultiSelect.createModel("rol1", "Role 1", 0));
         mselect.addOption(MultiSelect.createModel("rol2", "Role 1", 1));
         mselect.addOption(MultiSelect.createModel("rol3", "Role 1", 2));*/
    }

    public static native void newJSModule()/*-{
     var module = new $wnd.Logikas.ModuleImpl("m", "1.0.0");
     console.log(module);
     console.log(module.getName());
     }-*/;
}
