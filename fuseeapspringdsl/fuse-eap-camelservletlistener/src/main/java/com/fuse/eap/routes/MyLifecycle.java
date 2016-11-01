package com.fuse.eap.routes;

import org.apache.camel.component.servletlistener.CamelContextLifecycle;
import org.apache.camel.component.servletlistener.ServletCamelContext;
import org.apache.camel.impl.JndiRegistry;

import com.fuse.eap.endpoint.MyBean;
import com.fuse.eap.endpoint.MyCxfEndpoint;

public class MyLifecycle implements CamelContextLifecycle<JndiRegistry> {

	public void afterAddRoutes(ServletCamelContext arg0, JndiRegistry arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterStart(ServletCamelContext arg0, JndiRegistry registry) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterStop(ServletCamelContext arg0, JndiRegistry registry) throws Exception {
		
		
	}

	public void beforeAddRoutes(ServletCamelContext arg0, JndiRegistry registry) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void beforeStart(ServletCamelContext arg0, JndiRegistry registry) throws Exception {
		registry.bind("cxfbean", new MyBean());
		registry.bind("cxfEndpoint", new MyCxfEndpoint());
		
	}

	public void beforeStop(ServletCamelContext arg0, JndiRegistry arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
