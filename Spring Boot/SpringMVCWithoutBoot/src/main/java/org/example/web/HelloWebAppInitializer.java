package org.example.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HelloWebAppInitializer implements WebApplicationInitializer {

    // Method
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
        webApplicationContext.setConfigLocation("classpath:application-config.xml");

        // Creating a dispatcher servlet object
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

        // Registering a dispatcher Servlet with Servlet Context
        ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("myDispatcherServlet", dispatcherServlet);

        // Setting load on startup
        myCustomDispatcherServlet.setLoadOnStartup(1);

        // Adding mapping url (Custom URL)
        myCustomDispatcherServlet.addMapping("/example/*"); //да бъде достъпен на /example

        System.out.println("Dispatcher Servlet is registered successfully.");
    }
}
