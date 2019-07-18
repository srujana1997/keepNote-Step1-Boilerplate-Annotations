package com.stackroute.keepnote.cofiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

    public class Webconfig implements WebApplicationInitializer {
        @Override
        public void onStartup(ServletContext ctx) throws ServletException {
            AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
            webCtx.register(Config.class);
            webCtx.setServletContext(ctx);
            ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(webCtx));
            servlet.setLoadOnStartup(1);
            servlet.addMapping("/");
        }
    }