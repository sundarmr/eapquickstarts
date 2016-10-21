package com.eap.fuse.interceptors;

import java.io.InputStream;

import org.apache.camel.CamelContext;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class ResponseInterceptor extends AbstractPhaseInterceptor<Message> {

	
	public ResponseInterceptor() {
		super(Phase.RECEIVE);
		
	}
	
	/**
	 * Starts the camel route for AuditLog Inbound Message
	 * 
	 * @param message
	 * @throws Fault
	 */
	public void handleMessage(Message message) throws Fault {
		Exchange exchange = message.getExchange();
		try{

			InputStream is = message.getContent(InputStream.class);
			CachedOutputStream os = new CachedOutputStream();
			IOUtils.copy(is, os);
			os.flush();
			message.setContent(InputStream.class, os.getInputStream());
			is.close();
			String respponseXml = IOUtils.toString(os.getInputStream());
			System.out.println("Response printed from Intecetpor : " +respponseXml);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
