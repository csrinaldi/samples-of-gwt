package com.logikas.mvp.server.ioc;

import com.google.inject.persist.PersistFilter;
import com.google.inject.servlet.ServletModule;
import com.logikas.mvp.server.MVPRequestFactoryServlet;
import com.logikas.mvp.server.MVPServiceImpl;

public class IocServletModule extends ServletModule {

    @Override
    protected void configureServlets() {

        // Instalamos el módulo principal de nuestra aplicación
        install(new IocMainModule());

        // Inyectamos un servlet Filter que se activa con la URI /*
        // y permite mantener sesiones JPA con el patrón Open Session In View
        filter("/*").through(PersistFilter.class);

        // Atendemos los requerimientos hacia la URI /gwtRequest con un servlet
        // personalizado
        serve("/gwtRequest").with(MVPRequestFactoryServlet.class);
        serve("/Mvp/services").with(MVPServiceImpl.class);
    }
}
