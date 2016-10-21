package com.fuse.eap.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fuse.eap.Customer;

public class InitProcessor implements Processor{

	public void process(Exchange arg0) throws Exception {
		Customer customer = new Customer();
		customer.setName("Sundar");
		customer.setAge("33");
		customer.setCompanyName("Red Hat Inc.");
		customer.setAddressLine1("100");
		customer.setAddressLine2("East Davies Street");
		customer.setCity("Raleigh");
		customer.setState("NC");
		customer.setCountryName("USA");
		customer.setZipCode("30359");
		arg0.getOut().setBody(customer);
	}

}
