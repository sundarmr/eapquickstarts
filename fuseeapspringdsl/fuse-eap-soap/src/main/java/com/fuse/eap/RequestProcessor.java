package com.fuse.eap;

import java.math.BigInteger;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.predic8.common._1.PersonType;
import com.predic8.crm._1.CustomerType;
import com.predic8.wsdl.crm.crmservice._1.CreateType;

public class RequestProcessor implements Processor{

	public void process(Exchange arg0) throws Exception {
		
		
		CreateType type = new CreateType();
		CustomerType value= new CustomerType();
		value.setId(UUID.randomUUID().toString());
		PersonType personType = new PersonType();
		personType.setAge(new BigInteger("33"));
		personType.setFirstName("John");
		personType.setLastName("Doe");
		value.setPerson(personType);
		type.setCustomer(value);
		arg0.getOut().setBody(type);
	}

}
