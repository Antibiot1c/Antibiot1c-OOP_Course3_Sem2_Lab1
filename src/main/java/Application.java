package com.yourcompany;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.yourcompany.servlets.BookServlet;
import com.yourcompany.servlets.OrderServlet;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements ServletContextInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        registerServlets(servletContext);
    }

    private void registerServlets(ServletContext servletContext) {
        ServletRegistration.Dynamic bookServlet = servletContext.addServlet("BookServlet", new BookServlet());
        bookServlet.addMapping("/api/books");

        ServletRegistration.Dynamic orderServlet = servletContext.addServlet("OrderServlet", new OrderServlet());
        orderServlet.addMapping("/api/orders");
    }
}
