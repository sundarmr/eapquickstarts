package com.eap.fuse.interceptors;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.phase.Phase;

public class HeaderInterceptor extends AbstractSoapInterceptor {

	public HeaderInterceptor(String p) {
		super(Phase.POST_LOGICAL);
		// TODO Auto-generated constructor stub
	}

	public HeaderInterceptor() {
		super(Phase.POST_LOGICAL);
	}

	public void handleMessage(SoapMessage message) throws Fault {
		List<Header> headers = message.getHeaders();
		try {
			Authentication auth = new Authentication();
			auth.setUserName("sundar");
			auth.setPassword("password");

			Header header = new Header(new QName("http://model.examples.sundar.com", "auth"), auth,
					new JAXBDataBinding(Authentication.class));

			headers.add(header);

			message.put(Header.HEADER_LIST, headers);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
