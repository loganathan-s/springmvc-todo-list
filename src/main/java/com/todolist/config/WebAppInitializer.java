package com.todolist.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.lang.reflect.AnnotatedArrayType;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

	@Override
	public void onStartup (ServletContext servletContext) throws ServletException {

		log.info("onstart");



		// create the spring application context
		AnnotationConfigWebApplicationContext context =
			new AnnotationConfigWebApplicationContext();

		context.register(WebConfig.class);

		// create the dispatcher servelet
		DispatcherServlet dispatcherServlet =
			new DispatcherServlet(context);

		// register and configure the dispatcher servlet
		ServletRegistration.Dynamic registration
			= servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);

		//Configure startup loading of the server, container will load the servlet on startup
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}

}
