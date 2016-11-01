package com.fuse.eap.endpoint;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.cxf.CxfEndpoint;

public class MyCxfEndpoint implements Processor {

	CxfEndpoint cxfEndpoint = new CxfEndpoint();

	public void process(Exchange arg0) throws Exception {
		
		cxfEndpoint.setAddress("http://www.predic8.com:8080/crm/CustomerService");
		cxfEndpoint.setWsdlURL("http://www.predic8.com:8080/crm/CustomerService?wsdl");
		cxfEndpoint.setServiceClass("com.predic8.wsdl.crm.crmservice._1.CRMServicePT");
		cxfEndpoint.setCamelContext(arg0.getContext());
		
		ProducerTemplate createProducerTemplate = arg0.getContext().createProducerTemplate();
		List requestBody = createProducerTemplate.requestBody(cxfEndpoint, arg0.getIn().getBody(),java.util.List.class);
		
		arg0.getOut().setBody(requestBody);
		
	}

}
