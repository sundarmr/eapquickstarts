package com.eap.fuse;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
@ApplicationScoped
@Startup
@ContextName("mycamelContext")
public class MyRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("timer:foo?delay=2000&repeatCount=1").to("log:show?showAll=true&multiline=true");
		
	}
	
	

}
