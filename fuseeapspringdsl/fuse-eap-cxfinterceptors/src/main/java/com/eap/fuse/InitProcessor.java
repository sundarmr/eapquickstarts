package com.eap.fuse;

import java.math.BigInteger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.predic8.common._1.PersonType;
import com.predic8.crm._1.CompanyAddressType;
import com.predic8.crm._1.CustomerType;

public class InitProcessor implements Processor {
	
	public void process(Exchange exchange) throws Exception {
		
		String header = exchange.getIn().getHeader("operationName", String.class);
		if ("create".equalsIgnoreCase(header)) {
			CustomerType type = new CustomerType();
			PersonType personType = new PersonType();
			CompanyAddressType addressType = new CompanyAddressType();
			type.setPerson(personType);
			type.setAddress(addressType);
			type.setId(Math.abs(Math.random()) + "");
			personType.setAge(new BigInteger("33"));
			personType.setFirstName("Sundar");
			personType.setLastName("Munirathnam Rajendran");
			addressType.setCity("Atlanta");
			addressType.setCountry("USA");
			addressType.setCompanyName("Red Hat INC");
			exchange.getOut().setBody(type);
			exchange.getOut().setHeader("operationName", "create");
		}
		if("get".equalsIgnoreCase(header)){
			exchange.getOut().setBody("777");
			exchange.getOut().setHeader("operationName", "get");
		}
		
		if("getAll".equalsIgnoreCase(header)){
			exchange.getOut().setBody(new Object[0]);
			exchange.getOut().setHeader("operationName", "getAll");
		}

	}

}
