package com.logikas.gwt.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.js.JsType;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class gwt_sample implements EntryPoint {

    @JsType
    public interface Document {
        HTMLElement createElement(String name);

        public HTMLElement getElementsByTagName(String tag);
    }

    @JsType
    public interface Element{
        void setAttribute(String attr, String value);
    }
    
    @JsType
    public interface HTMLElement extends Element{

        public void appendChild(HTMLElement element);
    }
    
    @JsType
    public interface HTMLBodyElement extends HTMLElement{
    }
    
    @JsType
    public interface HTMLDivElement extends HTMLElement{
        
    }

    @Override
    public void onModuleLoad() {
        Document doc = getDocument();
        HTMLDivElement element = (HTMLDivElement) doc.createElement("DIV");
        HTMLElement body = doc.getElementsByTagName("BODY");
        element.setAttribute("align", "center");
        body.appendChild(element);
    }

    public static native Document getDocument() /*-{
     return $doc;
     }-*/;
}
