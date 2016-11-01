package com.fuse.eap.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfEndpoint;

public class MyRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setAddress("http://www.predic8.com:8080/crm/CustomerService");
        cxfEndpoint.setWsdlURL("http://www.predic8.com:8080/crm/CustomerService?wsdl");
        cxfEndpoint.setServiceClass("com.predic8.wsdl.crm.crmservice._1.CRMServicePT");
        cxfEndpoint.setCamelContext(getContext());
        
		from("timer:get?delay=4000&repeatCount=1").setHeader("operationName",constant("getAll")).to("bean:cxfbean").to(cxfEndpoint).to("log:response?showAll=true&multiline=true");
	}

}
